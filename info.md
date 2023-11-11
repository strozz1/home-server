# web server: http://192.168.1.29/
## IP for databases
### Database
- Ip: 192.168.1.29:5432  
- Data path: /home/admin/database/postgres : /var/lib/postgresql/data
- Enter DB:  psql -d home -U admin

### Docker
- create container: docker-compose up -d (same path as docker file)
- remove container: docker-compose down (same path as docker file)
- remove image: docker rmi <image-id>
- access container dash: docker exec -it <container-id> dash
- see logs: docker logs <container-id> --follow
- scp:  scp E:\Programacion\Proyectos\Java\Home-server\target\demo-0.1.jar admin@192.168.1.29:/home/admin/home-server


