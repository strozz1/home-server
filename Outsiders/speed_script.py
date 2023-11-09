import datetime
import re
import argparse
import json
import os
import subprocess
import sys
import pip._vendor.requests as requests
import httpx


def speed_check() -> json:
    #response = subprocess.Popen(["speedtest --simple"],stdout=subprocess.PIPE, shell=True).stdout.read().decode('utf-8')
    response= "Ping: 20.162 msDownload: 729.46 Mbit/sUpload: 179.59 Mbit/s"

    ping = re.search(r"Ping:\s+(\d+\.\d+)\s+ms", response)
    upload = re.search(r"Upload:\s+(\d+\.\d+)\s+Mbit/s", response)
    download = re.search(r"Download:\s+(\d+\.\d+)\s+Mbit/s", response)

    ping = float(ping.group(1))
    upload = float(upload.group(1))
    download = float(download.group(1))
    now = datetime.datetime.now()
    now = now.strftime("%Y-%m-%dT%H:%M:%S")
    dict={
        "time": now,
        "ping": ping,
        "download": download,
        "upload": upload
    }
    return dict


def send_data(url,json):
    headers = {'Content-type': 'application/json', 'Accept': 'application/json'}
    try:
        x = httpx.post(url, json=json,headers=headers)
        print('Data sent. Code:',x.status_code,', description:',x.text)
        return x.status_code
    except Exception as e:
        print('Error sending POST. Reason: ',e)
        return 500

def write_error(url,code,path):
      date_time = datetime.datetime.now()
      path =path+"errors.log"
      with open(path, "a") as f:
        f.write(f"{date_time}\n")
        # Se escribe la URL de la solicitud.
        f.write(f"URL: {url}\n")
        # Se escribe el error.
        f.write(f"Error: {code}\n")

#check param url
parser = argparse.ArgumentParser(description="Verifica que los argumentos de cmd contengan una URL.")
parser.add_argument("url", help="La URL que se va a verificar.")
parser.add_argument("error_path", help="La ruta donde se guardan los errores.")

args = parser.parse_args()
if not os.path.isdir(args.error_path):
    print('Error path is not valid.')
    sys.exit(1)
print("Starting speed check.")

result = speed_check()
print('Speed test made. Result:\n',result)
code = send_data(args.url,result)
if code !=200:
    write_error(args.url,code,args.error_path)
else: 
    print('POST request sent.')
