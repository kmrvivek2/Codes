package quickRun;

/*
You are give two tables, flights and airports with the following structure

flights(start_port char(3) NOT NULL, end_port char(3) NOT NULL)
airports(city_name varchar(17) NOT NULL, port_code char(3) NOT NULL)

Each row in the table flights contains information about a flight:
code of departure port(start_port) and code of destination port(end_port).

Each row in the table flights contains information about an airport:
the city name(city_name) and the port code(port_code).
Each port_code is assigned to at most one airport.

Write an SQl query that finds all cities through which a flight from New York
to Tokyo may pass if the passenger wants to make exactly one change of flights.

SELECT DISTINCT a1.city_name AS layover_city
FROM flights f1
JOIN flights f2 ON f1.end_port = f2.start_port
JOIN airports a1 ON f1.end_port = a1.port_code
JOIN airports a2 ON f1.start_port = a2.port_code
JOIN airports a3 ON f2.end_port = a3.port_code
WHERE a2.city_name = 'New York'
  AND a3.city_name = 'Tokyo';


 */

public class Test4 {
    public static void main(String[] args) {
        int a = 10;
    }
}
