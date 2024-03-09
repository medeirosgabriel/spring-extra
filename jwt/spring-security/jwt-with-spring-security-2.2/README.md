# Example:
- ## Spring Security
- ## Authorization
- ## Two filters (Login, Authentication)
- ## Repository of Roles
- ## More than one role by user
- ## Return token in the response body
# Requests:
	Request: curl -v -X POST localhost:8081/login -H 'Content-Type: application/json' -d '{"email": "maria@gmail.com", "password": "123456"}'
	Response: Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJ...

	Request: curl -v -X POST localhost:8081/users -H 'Content-Type: application/json' -d '{"email": "gabriel@gmail.com", "name": "gabriel", "password": "123456"}'
	Response: {"email":"gabriel@gmail.com","name":"gabriel","password":"123456"}

	Request: curl -v -X GET localhost:8081/users/gabriel@gmail.com -H 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJ...'
	Response: {"email":"gabriel@gmail.com","name":"gabriel","password":"123456"}

