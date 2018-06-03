**Beer Service**
 -
Beer service is responsible for keeping and delivering data concerning beer (CRUD paradigm - create, read, update, delete). It was developed with the use of framework Spring Boot (Java 8).
It consists of two packages. One focusing on beer, the other on regions. Both have the same structure, which covers `Model`, `Repository`, `Service` and `Controller`.
* `Repository` stores the data.
* `Model` presents data stored in data `Repository`.
* `Service` is responsible for getting data from and saving to `Repository`, then performing business logic on this data.
* `Controller` gives an access to the service operations via `REST API`
 
Addresses provided by BeerController:
* `/beer/add` - adds beer to repository. Consumes data in `JSON` format (e.g. `{“userId”: 1, “name”: “name1”, “style”: “style1”, “abv”: 1, “blg”: 2, “ibu”: 3, “date”: 4, “left”: 5, “price”: 6, “desc”: “desc1”, “regionId”: 1}`)
* `/beer/get/1` - gets beer with given beerId (e.g. `id=1`)
* `/beer/get_by_user/1` - gets all beers which belongs to user with given userId (e.g. `id=1`)
* `/beer/get_by_style/ale` - gets all beers with given style (e.g. `style=ale`)
* `/beer/get_by_region/1` - gets all beers with given regionId (e.g. `regionId=1`)
* `/beer/find` - gets all beers with given constraints
* `/beer/remove` - removes beer with given `beerId` (e.g. `beerId=1`)

Addresses provided by RegionController:
* `/region/get` - gets all regions (regions are predefined -> `data.sql`)

By default beer-service starts on `localhost` with port `8082`.

Service was tested using `curl` program. Exemplary tests:
* `curl -v -H "Accept: application/json" -H "Content-type: application/json" -X POST 'http://localhost:8082/beer/add' -d '{“userId”: 1, “name”: “name1”, “style”: “style1”, “abv”: 1, “blg”: 2, “ibu”: 3, “date”: 4, “left”: 5, “price”: 6, “desc”: “desc1”, “regionId”: 1}’'`
* `curl -v -X GET 'http://localhost:8082/beer/get_by_user/1'`
* `curl -v -X GET 'http://localhost:8082/beer/get_by_style/1'`
* `curl -v -X GET 'http://localhost:8082/beer/get_by_region/1'`
* `curl -v -X GET 'http://localhost:8082/beer/find?userId=1&style=style1'`
* `curl -v -X DELETE 'http://localhost:8082/beer/remove/1'`

- before commit `011d56b`:
* `curl -v -X POST 'http://localhost:8082/beer/add' -d 'userId=1&name=name1&style=style1&abv=1&blg=2&ibu=3&date=4&left=5&price=6&desc=desc1&regionId=1'`
* `curl -v -X GET 'http://localhost:8082/beer/get_by_user' -d 'userId=1'`
* `curl -v -X GET 'http://localhost:8082/beer/get_by_style' -d 'style=style1'`
* `curl -v -X GET 'http://localhost:8082/beer/get_by_region' -d 'regionId=1'`



