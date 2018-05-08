**Beer Service**
 -
Beer service is responsible for keeping and delivering data concerning beer. It was developed with the use of framework Spring Boot (Java 8).
It consists of two packages. One focusing on beer, the other on regions. Both have the same structure, which covers `Model`, `Repository`, `Service` and `Controller`.
* `Repository` stores the data.
* `Model` presents data stored in data `Repository`.
* `Service` is responsible for getting data from and saving to `Repository`, then performing business logic on this data.
* `Controller` gives an access to the service operations via `REST API`
 
Addresses provided by BeerController:
* `/beer/add?userId=1&name=name1&style=style1&abv=1&blg=2&ibu=3&date=4&left=5&price=6&desc=desc1&regionId=1` - adds beer to repository
* `/beer/get?id=1` - gets beer with given beerId (e.g. `id=1`)
* `/beer/get_by_user?userId=1` - gets all beers which belongs to user with given userId (e.g. `id=1`)
* `/beer/get_by_style?style=ale` - gets all beers with given style (e.g. `style=ale`)
* `/beer/get_by_region?regionId=1` - gets all beers with given regionId (e.g. `regionId=1`)

Addresses provided by RegionController:
* `/region/get` - gets all regions (regions are predefined -> `data.sql`)

By default beer-service starts on `localhost` with port `8082`.

Service was tested using `curl` program. Exemplary tests:
*	`curl -v -X POST 'http://localhost:8082/beer/add' -d 'userId=1&name=name1&style=style1&abv=1&blg=2&ibu=3&date=4&left=5&price=6&desc=desc1&regionId=1'`
* 	`curl -v -X GET 'http://localhost:8082/beer/get_by_user' -d 'userId=1'`
*	`curl -v -X GET 'http://localhost:8082/beer/get_by_style' -d 'style=style1'`
*	`curl -v -X GET 'http://localhost:8082/beer/get_by_region' -d 'regionId=1'`



