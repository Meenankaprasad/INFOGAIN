
1. Create a database called 'rewards' in your database and update database connection properties in application.properties file.

2. Start the application as Spring-Boot app after installing the required dependencies.

3. Insert test data by running the below scripts. You can add more data, if needed.

INSERT INTO rewards.transactions
(transaction_id, transaction_amount, transaction_time, userid)
VALUES(1, 55, '2022-01-01 00:00:00.000', 1);
INSERT INTO rewards.transactions
(transaction_id, transaction_amount, transaction_time, userid)
VALUES(3, 99, '2022-03-01 00:00:00.000', 1);
INSERT INTO rewards.transactions
(transaction_id, transaction_amount, transaction_time, userid)
VALUES(5, 120, '2022-02-01 00:00:00.000', 1);
INSERT INTO rewards.transactions
(transaction_id, transaction_amount, transaction_time, userid)
VALUES(2, 120, '2022-02-01 00:00:00.000', 2);
INSERT INTO rewards.transactions
(transaction_id, transaction_amount, transaction_time, userid)
VALUES(4, 105, '2022-02-02 00:00:00.000', 2);
INSERT INTO rewards.transactions
(transaction_id, transaction_amount, transaction_time, userid)
VALUES(6, 300, '2022-03-01 00:00:00.000', 3);


4. Test the service by opening the URL: http://localhost:8080/rewards/{userId} in a browser or through any Rest client like Postman.
Available user IDs in test data 1,2,3

5. Sample URL: http://localhost:8080/rewards/1
   Sample Response: 
   {
	    "headers": {},
	    "body": {
	        "totalRewardPoints": 144,
	        "monthlyData": [
	            {
	                "month": "JANUARY",
	                "rewardPoints": 5
	            },
	            {
	                "month": "MARCH",
	                "rewardPoints": 90
	            },
	            {
	                "month": "FEBRUARY",
	                "rewardPoints": 49
	            }
	        ]
	    },
	    "statusCode": "OK",
	    "statusCodeValue": 200
	}
	
	User 1 made a transaction of $55 in January, $99 in February, $120 in March. So, 5 reward points(55-50) for the month of January, 49 points(99-50) in February and 90 points(50 + 2*20) for March.
	
	
	