**Beer Service**
 -
 By default beer-service starts on `localhost` with port `8082`.
 Beer addresses:
* `/beer/add?userId=1&name=name1&style=style1&abv=1&blg=2&ibu=3&date=4&left=5&price=6&desc=desc1&regionId=1` - adds beer to repository
* `/beer/get?id=1` - gets beer with given beerId (e.g. `id=1`)
* `/beer/get_by_user?userId=1` - gets all beers which belongs to user with given userId (e.g. `id=1`)
* `/beer/get_by_style?style=ale` - gets all beers with given style (e.g. `style=ale`)
* `/beer/get_by_region?regionId=1` - gets all beers with given regionId (e.g. `regionId=1`)
* `/region/get` - gets all regions (regions are predefined -> `data.sql`)
