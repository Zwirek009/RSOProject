**Beer Service**
 -
 Głównym zadaniem _Beer service_ jest przechowywanie oraz udostępnianie danych dotyczących piw dodawanych przez użytkowników systemu.
 Serwis powstał przy platformy programistycznej SpringBoot opartej na technologii Java.
 
 _Beer service_ składa się z dwóch pakietów - `beer` i `region`.
 Są one podzielone na 4 warstwy:
* `Repository` przechowuje dane.
* `Model` przedstawia dane przechowywane przez `Repository`.
* `Service` przeprowadza operacje na danych przechowywanych przez `Repository`, ponadto odpowiada za wykonywanie operacji na danych wynikających z logiki biznesowej.
* `Controller` udostępnia dostęp do funkcjonalności po przez wystawione `REST API` 
 
Adresy udostępnione przez BeerController:
* `/beer/add` - dodaje piwo do repozytorium o danych przedstiowanych w formacie `JSON` (przykładowe dane piwa: `{“userId”: 1, “name”: “name1”, “style”: “style1”, “abv”: 1, “blg”: 2, “ibu”: 3, “date”: 4, “left”: 5, “price”: 6, “desc”: “desc1”, “regionId”: 1}`)
* `/beer/get/1` - zwraca dane piwa o zadanym beerId (w przykładzie `beerId=1`)
* `/beer/get_by_user/1` - zwraca listę piw użytkownika o userId (w przykładzie `userId=1`)
* `/beer/get_by_style/ale` - zwraca listę piw o zadanym typie piwa (w przykładzie `typ=ale`)
* `/beer/get_by_region/1` - zwraca listę piw udostępnionych w ramach zadanego regionId (w przykładzie `regionId=1`)


Adresy udostępnione przez RegionController:
* `/region/get` - zwarca listę regionów

Bez dodatkowej konfiguracji _Beer service_ uruchamia się na porcie `8082`.

Serwis był testowany przy użyciu programu `curl`.


Przykładowy scenariusz testowy (do wykonania używając programu curl):
* `curl -v -H "Accept: application/json" -H "Content-type: application/json" -X POST 'http://localhost:8082/beer/add' -d '{“userId”: 1, “name”: “name1”, “style”: “style1”, “abv”: 1, “blg”: 2, “ibu”: 3, “date”: 4, “left”: 5, “price”: 6, “desc”: “desc1”, “regionId”: 1}’'`
* `curl -v -X GET 'http://localhost:8082/beer/get_by_user/1'`
* `curl -v -X GET 'http://localhost:8082/beer/get_by_style/1'`
* `curl -v -X GET 'http://localhost:8082/beer/get_by_region/1'`
- do wersji przed zmianami `011d56b`:
* `curl -v -X POST 'http://localhost:8082/beer/add' -d 'userId=1&name=name1&style=style1&abv=1&blg=2&ibu=3&date=4&left=5&price=6&desc=desc1&regionId=1'`
* `curl -v -X GET 'http://localhost:8082/beer/get_by_user' -d 'userId=1'`
* `curl -v -X GET 'http://localhost:8082/beer/get_by_style' -d 'style=style1'`
* `curl -v -X GET 'http://localhost:8082/beer/get_by_region' -d 'regionId=1'`

