# kotlin-fitbit-integration
a sample project to demo kotlin , springboot, fitbit integration 

# Steps to run the application / integrate with fitbit

### Step 1 
Register your app on fitbit [here](https://dev.fitbit.com/apps/new)

### Step 2
Once you register your app on fitbit, you'll get client secret and client id. Update `client secret` and `client id` in application yaml  

### Step 3
Start the spring boot application and hit `http://localhost:8080/test` . It should redirect you to fitbit authorization page . once authorized, you can retrieve health data

### Step 4
Use following endpoints to fetch data 
 - `http://localhost:8080/heartRate/{date}/{period}` . [Fitbit api doc](https://dev.fitbit.com/build/reference/web-api/heart-rate/)
 - `http://localhost:8080/fitbit/sleep/{date}` . [Fitbit API doc](https://dev.fitbit.com/build/reference/web-api/sleep/)
 - `http://localhost:8080/fitbit/weight/{date}/{period}` . [Fitbit Api doc](https://dev.fitbit.com/build/reference/web-api/body/)

# Tech Stack 
- Kotlin 
- Spring boot 
- Spring boot oauth2 client
- gradle 
- feign 
