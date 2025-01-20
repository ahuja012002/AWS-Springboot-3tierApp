# AWS 3 TIER APPLICATION


## In this Project, I have built a scalable, Resilient and Secure Employee Management System using a 3-tier Application on Spring boot, Thymeleaf and AWS RDS database.

•	The application is also secured with OAuth2 with social login such as Github. 

•	The application is then  deployed on AWS EC2. I created Custom AMI with the deployables, Created Launch templates, Target Groups, Auto Scaling groups and finally put everything behind an Application load balancer.

•	I have also setup a new VPC, subnets, NAT Gateway, route tables for proper network connectivity.


## Basic Definition of 3-Tier :

A 3-tier application is made up of a Web tier , application tier and a database tier.
In this Project a web-tier is Thymeleaf templates.
Application tier is Spring boot Rest API's
Database tier is AWS RDS.

## Lets create a basic infrastructure in AWS before jumping into building the Spring boot Application :

### CREATE VPC :

 1. Navigate to the AWS Console and search VPC and create the VPC by giving any name and IPV4 CIDR as 10.0.0.0 /16

    <img width="1152" alt="Screenshot 2025-01-19 at 3 46 38 PM" src="https://github.com/user-attachments/assets/d4c873fc-6ced-4224-bb82-9c1add96b762" />


    ### CREATE SUBNET

After creating the VPC, we have to create the subnets (It is a group of IP address within VPC)

2. Navigate to subnet and click create subnet and provide the values as below
3. We will create 4 subnets, 1 public and private subnet in each AZ, so totally 4 subnets. 

4. Create the 4 subnets with non overlapping CIDR values within the VPC just created.

    <img width="1323" alt="Screenshot 2025-01-19 at 3 52 55 PM" src="https://github.com/user-attachments/assets/45889938-6727-4cc7-b46b-ac491ece3ee4" />

<img width="1310" alt="Screenshot 2025-01-19 at 3 55 44 PM" src="https://github.com/user-attachments/assets/e0bd459e-4632-447e-b7b3-580be4459e90" />

<img width="1417" alt="Screenshot 2025-01-19 at 3 56 21 PM" src="https://github.com/user-attachments/assets/c1d8ef93-105e-495f-9a0d-bb0e1a3d37f8" />

<img width="1417" alt="Screenshot 2025-01-19 at 3 56 21 PM" src="https://github.com/user-attachments/assets/c3faf8d4-b2df-4db5-81db-130c97167899" />


   ### CREATE ROUTE TABLE
   <img width="1324" alt="Screenshot 2025-01-19 at 4 01 37 PM" src="https://github.com/user-attachments/assets/e6505cba-a07b-4c74-8ced-452b4f45043a" />
<img width="1324" alt="Screenshot 2025-01-19 at 4 01 37 PM" src="https://github.com/user-attachments/assets/5d2f0fac-ca3c-4f57-a961-628a8e730a36" />

Edit the subnet associations to associate Private Subnets to Private Route table and Public Subnets to Public RouteTable

   ### CREATE INTERNET GATEWAY
Search for Internet Gateway and Click Create Internet Gateway . Enter the name and click create.
   ### EDIT ROUTES
   <img width="1659" alt="Screenshot 2025-01-19 at 4 11 49 PM" src="https://github.com/user-attachments/assets/ea241949-edae-4673-b556-e3a4d7a7808c" />


   ### CREATE NAT GATEWAY
Instances in the Private Subnet cannot talk to internet. In order for them to talk to internet, we need to create a NAT Gateway in Public subnet .
   ![image](https://github.com/user-attachments/assets/40189e00-bf0f-42f4-9b32-3f02b5d4f4b1)

Edit the Private subnet route tables and point them to Nat Gateway.
This will make sure traffic from instances in Private subnet goes through NAT Gateway
<img width="1457" alt="Screenshot 2025-01-19 at 4 17 10 PM" src="https://github.com/user-attachments/assets/a37a1587-d3d4-4dcc-be3a-d7c5e9dbf3d2" />

## Lets Create AWS RDS database.
For instructions on how to create RDS MySQL database, please refer the README.md section of the below repository: 
https://github.com/ahuja012002/AWS-RDS--Springboot

## Lets now Spin up EC2 instance.
search for EC2 and spin up instance as shown in the below screenshots .

<img width="1042" alt="Screenshot 2025-01-19 at 4 25 43 PM" src="https://github.com/user-attachments/assets/61b87503-b1af-4dcc-a887-bed8896a6666" />

<img width="1154" alt="Screenshot 2025-01-19 at 4 25 50 PM" src="https://github.com/user-attachments/assets/d5597765-e2cb-4471-a7ae-63efd567cb97" />

<img width="1094" alt="Screenshot 2025-01-19 at 4 25 59 PM" src="https://github.com/user-attachments/assets/8e739dee-72e9-4db1-adeb-d4331234681c" />

Also, enable port range 8000-9000 custom TCP as our application will run on 8081.

Let us now start building the Spring boot App  with Thymeleaf as presentation layer and AWS RDS as Backend Database. This app once completed, will be deployed in the Ec2 instance we just spun up.

Navigate to https://start.spring.io and select the defaults for Java, Maven and Spring boot version . Add the below dependencies as shown in the screenshot and Click Generate:

<img width="1499" alt="Screenshot 2025-01-19 at 11 31 17 AM" src="https://github.com/user-attachments/assets/c90d7113-2814-46c2-a98f-0a7ba2638bf9" />

Import the Project into any IDE of your choice e.g. Eclipse

Lets Setup the basic Spring boot App by developing Simple Employee Management System.

Domain Class Employee.java : Lets create a Domain Class which will serve as our entity and also the bean for our presentation layer :

<img width="607" alt="Screenshot 2025-01-19 at 11 34 44 AM" src="https://github.com/user-attachments/assets/ba9b8b52-9e67-43dd-a140-0fc9dcfb6c0b" />

Then , Lets add the Controller class EmployeeController.Java and Service and Repository layers . The controller class will accept the request and return the response to the UI layer.

The Service layer will invoke the repository methods for CRUD operations like Adding new Employee, Update Existing Employee and Fetch Employee details and Delete Employee .
<img width="790" alt="Screenshot 2025-01-19 at 11 38 26 AM" src="https://github.com/user-attachments/assets/25f6512d-30d1-4d22-9a93-5101d7a00a7a" />

<img width="789" alt="Screenshot 2025-01-19 at 11 39 01 AM" src="https://github.com/user-attachments/assets/1ecb566a-0f7e-4404-b870-793a58fbcd89" />

<img width="698" alt="Screenshot 2025-01-19 at 11 39 29 AM" src="https://github.com/user-attachments/assets/7ca8fcdc-9b31-40d3-b17d-1ef87c4758da" />

Let us now Add UI templates. 
Home.html will be our home page to display all the employees. This will have option to add new employee, Update employee or Delete Employee.

<img width="794" alt="Screenshot 2025-01-19 at 11 42 42 AM" src="https://github.com/user-attachments/assets/55817d7c-a043-4545-a806-e0513c595284" />

Update.html will be the form to update details of existing employee.

<img width="794" alt="Screenshot 2025-01-19 at 11 42 42 AM" src="https://github.com/user-attachments/assets/bb1450b6-f915-46a6-b048-9e0f1150fa25" />

newemployee.html will be the form to add new employee details.

<img width="794" alt="Screenshot 2025-01-19 at 11 42 42 AM" src="https://github.com/user-attachments/assets/49431de9-d8ea-4a92-9172-b481b411fcca" />

I have also added some cSS styling to beautify it.  This is optional.

Now, Let's make it secure by adding social Authentication with Github.

First of all, lets add a connected add in github. Navigate to https://github.com/settings/developers

Click on Create new OAuth2 Application.

Enter the details like Application name, Application description. Also, if we have some logo, We can upload that.

Authorization callback url will be : http://localhost:8081/login/oauth2/code/github.

We can create similar OAuth2 App in Google or Aamzon to use other social logins.

Lets Add the required configurations in our code.

First of all, we need to add annotation @EnableWebSecurity in our Spring boot main class.
<img width="537" alt="Screenshot 2025-01-19 at 11 52 45 AM" src="https://github.com/user-attachments/assets/535a43e7-49b8-4ecf-a17c-3d9b02c26ab4" />

Lets now create a new SecurityConfig class and add rules for authentication and adding a custom login page.
As shown in the below screenshot, any request with "/" or "/login" will not need authentication as it will be landing page and custom login page (which we will create). Any other request  will need to be authenticated.
<img width="911" alt="Screenshot 2025-01-19 at 11 53 57 AM" src="https://github.com/user-attachments/assets/a7602404-2a3b-4f99-b43c-275c6ceedce1" />


Also, as shown in the screenshot, on login it will take the flow to "/login" which will then go to EmployeeController which redirects to custom_login.html
Also, on successful login, it goes to home page.

Let's now create a custom_login.html page which will show the option to the user to login with github.

<img width="524" alt="Screenshot 2025-01-19 at 11 59 04 AM" src="https://github.com/user-attachments/assets/9d366bd5-c0c9-423a-9734-db8d777f53b7" />

Again the styling is optional.

Finally, Lets create a login controller to capture the details of logged in user.

<img width="524" alt="Screenshot 2025-01-19 at 11 59 04 AM" src="https://github.com/user-attachments/assets/ad8e1617-2736-409c-8d68-9508d00d87ec" />

Let us now see application.properties file.

We need to add below two properties for spring security :
spring.security.oauth2.client.registration.github.clientId=Your Client id
spring.security.oauth2.client.registration.github.clientSecret= Your Client secret

Now, its time to run the application :
Open your browser and type http://localhost:8081. It should show below screen.

<img width="579" alt="Screenshot 2025-01-19 at 12 00 13 PM" src="https://github.com/user-attachments/assets/ed67e60c-ce57-4661-a713-9596b4c004a5" />

once you login it should show the home page and try peforming any operations.

<img width="579" alt="Screenshot 2025-01-19 at 12 00 13 PM" src="https://github.com/user-attachments/assets/4dac6262-87cb-4d95-80bb-03bcb2ca77e9" />


# DEPLOYING THE APPLICATION on EC2
Now, lets do mvn clean install to generate the deployable jar file

SSH to EC2 instance using its public IP
install java
copy the jar file to the EC2 instance using SCP command.
run the application.
At this moment, we have successfully installed spring boot application on Ec2.

<img width="1563" alt="Screenshot 2025-01-19 at 8 29 37 PM" src="https://github.com/user-attachments/assets/dd442915-19f8-4855-9051-7a0910b9573c" />

# BELOW ARE THE NEXT STEPS

## Create a Custom AMI
<img width="1552" alt="Screenshot 2025-01-19 at 8 51 08 PM" src="https://github.com/user-attachments/assets/d30359dd-dbb7-42d7-b770-de54a45949e7" />
<img width="1580" alt="Screenshot 2025-01-19 at 8 51 35 PM" src="https://github.com/user-attachments/assets/f9c0a7cf-76a3-40c8-a91b-5b253829a191" />

## Launch Instance from Custom AMI
<img width="1580" alt="Screenshot 2025-01-19 at 8 51 35 PM" src="https://github.com/user-attachments/assets/8f5d1b04-77ec-4a5f-8938-46d50ad5124a" />

## Validate Application from new Instance
<img width="1122" alt="Screenshot 2025-01-19 at 9 18 17 PM" src="https://github.com/user-attachments/assets/7cc81555-b038-48a5-a99c-148644610c3e" />

## Create Launch Template
<img width="868" alt="Screenshot 2025-01-20 at 11 19 21 AM" src="https://github.com/user-attachments/assets/d9fbc39e-7081-4172-8ced-cc4f3c384c82" />

## Launch Instance Using Launch Template
<img width="1375" alt="Screenshot 2025-01-20 at 11 19 29 AM" src="https://github.com/user-attachments/assets/e21904c1-eb5d-4f1c-8e4d-bf7694fd44b5" />

## Create Autoscaling Group
<img width="1761" alt="Screenshot 2025-01-20 at 12 50 26 PM" src="https://github.com/user-attachments/assets/6581b496-d521-42e4-bd22-25c2a636b1df" />


## Create Target Group
<img width="1518" alt="Screenshot 2025-01-20 at 1 01 46 PM" src="https://github.com/user-attachments/assets/86d90da8-b99a-4f2f-bc10-1ac6d317f301" />

## Port Mappings in Target group
Map the target group port to the port in our spring boot application.
## Create Application Load Balancer
<img width="1390" alt="Screenshot 2025-01-20 at 1 21 02 PM" src="https://github.com/user-attachments/assets/66a19fd3-1955-4907-9134-a414adc6c7df" />

<img width="1538" alt="Screenshot 2025-01-20 at 1 23 04 PM" src="https://github.com/user-attachments/assets/8e324f89-1a4b-41d9-8deb-ac3d96d08d5f" />

## Map to Target Group
Map the load Balancer to the target group
## Update AutoScaling Group to include ALB
Update Load Balancer to include the AutoScaling Group
## Validate the application using ALB endpoint
Once , we complete all these steps we can validate our application with ALB DNS name.
<img width="1396" alt="Screenshot 2025-01-20 at 1 25 09 PM" src="https://github.com/user-attachments/assets/93598732-9d90-413d-96ca-682f71c78497" />

If you have reached till this point, Thanks for Reading !!
Hope this was useful

Thank you 
Rahul Ahuja






