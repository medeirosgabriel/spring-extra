# Example:
- ## Spring Security
- ## No Authorization
- ## One filter
# Requests:
	Request: curl -v -X POST localhost:8081/auth -H 'Content-Type: application/json' -d '{"user": "maria@gmail.com", "pass": "1234"}'
	Response: {"type":"Bearer","token":"eyJhbGciOiJIUzI1NiJ9...."}

	Request: curl -v -X GET localhost:8081/actuator/health -H 'Content-Type: application/json' -H 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9....'
	Response: {"status":"UP"}