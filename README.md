Jenkins Deployment Using Docker (Ubuntu Server)

Overview
This project demonstrates how to deploy Jenkins as a container using Docker on an Ubuntu server. The setup is accessed remotely via SSH and configured through the Jenkins web interface.
Environment
* OS: Ubuntu Server 
* Server IP: 192.168.1.124 
* Access Method: SSH (Git Bash on Windows)
Technologies
* Jenkins 
* Docker 
* Linux

Setup Steps
1. Connect to Server
ssh ali-abdul-aleem@192.168.1.124

2. Run Jenkins Container
docker run -p 8080:8080 \
-p 50000:50000 \
-d -v jenkins_home:/var/jenkins_home \
jenkins/jenkins:lts

Explanation:
* 8080 ? Jenkins Web UI 
* 50000 ? Agent communication 
* jenkins_home ? Persistent storage for Jenkins data

3. Verify Container
docker ps

4. Retrieve Initial Admin Password
docker exec <container_id> cat /var/jenkins_home/secrets/initialAdminPassword

5. Access Jenkins
Open in browser:
http://192.168.1.124:8080

7. Initial Setup
* Enter the admin password 
* Select Install suggested plugins 
* Create admin user




