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
    #response = subprocess.Popen(["speedtest --simple --secure"],stdout=subprocess.PIPE, shell=True).stdout.read().decode('utf-8')
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

result = speed_check()
print(result)