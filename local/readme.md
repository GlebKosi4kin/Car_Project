```
docker run --hostname=588afa871a9d --mac-address=fe:68:f2:23:5f:1a --env=MYSQL_ALLOW_EMPTY_PASSWORD=true --env=MYSQL_RANDOM_ROOT_PASSWORD=false --env=PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin --env=GOSU_VERSION=1.17 --env=MYSQL_MAJOR=innovation --env=MYSQL_VERSION=9.4.0-1.el9 --env=MYSQL_SHELL_VERSION=9.4.0-1.el9 --volume=/var/lib/mysql --network=bridge --workdir=/ -p 3311:3306 --restart=no --runtime=runc -d mysql:latest
```
