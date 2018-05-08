**Beer Service**
 -
 Głównym zadaniem _Beer service_ jestprzechowywanie oraz udostępnianie danych dot. piw dodawanych przez użytkowników systemu.
 Serwis powstał przy platformy programistycznej SpringBoot opartej na technologii Java.
 
 _Beer service_ składa się z dwóch pakietów - `beer` i `region`.
 Są one podzielone na 4 warstwy:
* `Repository` przechowuje dane.
* `Model` przedstawia dane przechowywane przez `Repository`.
* `Service` przeprowadza operacje na danych przechowywanych przez `Repository`, ponadto odpowiada za wykonywanie operacji na danych wynikających z logiki biznesowej.
* `Controller` udostępnia dostęp do funkcjonalności po przez wystawione `REST API` 
 
Adresy udostępnione przez BeerController:
* `/beer/add?userId=1&name=name1&style=style1&abv=1&blg=2&ibu=3&date=4&left=5&price=6&desc=desc1&regionId=1` - dodaje piwo do repozytorium
* `/beer/get?id=1` - zwraca dane piwa o zadanym beerId (e.g. `id=1`)
* `/beer/get_by_user?userId=1` - zwraca listę piw użytkownika o userId (e.g. `id=1`)
* `/beer/get_by_style?style=ale` - zwraca listę piw o zadanym typie piwa (e.g. `style=ale`)
* `/beer/get_by_region?regionId=1` - zwraca listę piw udostępnionych w ramach zadanego regionId (e.g. `regionId=1`)

Adresy udostępnione przez RegionController:
* `/region/get` - zwarca listę regionów

Bez dodatkowej konfiguracji _Beer service_ uruchamia się na porcie `8082`.

Serwis był testowy przy użyciu programu `curl`. 
Przykładowy scenariusz testowy:
*	`curl -v -X POST 'http://localhost:8082/beer/add' -d 'userId=1&name=name1&style=style1&abv=1&blg=2&ibu=3&date=4&left=5&price=6&desc=desc1&regionId=1'`
* 	`curl -v -X GET 'http://localhost:8082/beer/get_by_user' -d 'userId=1'`
*	`curl -v -X GET 'http://localhost:8082/beer/get_by_style' -d 'style=style1'`
*	`curl -v -X GET 'http://localhost:8082/beer/get_by_region' -d 'regionId=1'`



