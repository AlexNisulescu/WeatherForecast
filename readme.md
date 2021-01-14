# :computer:Aplicatie prognoza meteo :sun_behind_rain_cloud:
<a href="https://www.java.com/en/"><img src="https://img.shields.io/badge/language-JAVA-brightgreen"></a>
<a href="https://www.jetbrains.com/idea/"><img src="https://img.shields.io/badge/compiler-Intellij-red"></a>
<a href="#"><img src="https://img.shields.io/badge/GUI-FXML-blue"></a>
<a href="https://openweathermap.org/"><img src="https://img.shields.io/badge/API-WeatherCast-yellow"></a>
<a href="https://openweathermap.org/"><img src="https://img.shields.io/badge/Tool-Maven-orange"></a>

## Cuprins
- [Introducere](#Introducere)
- [Utilizarea aplicatiei](#Utilizarea aplicatiei)
- [Limbaj](#Limbaj)
- [Realizator](#Realizator)
***
## Introducere
    Acest proiect isi propune sa implementeze un program in limbajul Java ce va
    oferi o interfata grafica pentru citirea prognozei meteo. Pentru aceasta 
    utilizatorul poate alege din choiceboxurile puse la dispozitie sau poate
    cauta orasul folosind searchboxul.
***
## Utilizarea aplicatiei
    Odata pornita, aplicatia va contine doua casute, de unde utilizatorul va
    trebui sa selecteze tara si orasul pentru doreste sa afle prognoza meteo,
    sau un searchbox unde acesta va trebui sa introduca numele orasului cautat,
    iar mai apoi, pe ecran acesta va vedea prognoza meteo pentru respectivul
    oras. De precizat este ca in cazul in care acesta cauta orasul dupa nume,
    trebuie sa aiba mare grija la corectitudinea numelui.

### Exemplu Structura Fisier de Intrare
| ID Oras   | Nume Oras | Latitudine  | Longitudine | Cod Tara |
|:---------:|:---------:|:-----------:|:-----------:|:--------:|
|819827     |Razvilka   |55.591667    |37.740833    |RU        |
|524901     |Moscow     |55.752220    |37.615555    |RU        |
|2973393    |Tarascon   |43.805828    |4.660280     |FR        |
|2986678    |Ploufragan |48.491409    |-2.794580    |FR        |

    Este important ca fisierul de intrare sa aiba structura aceasta!
    Pentru a nu modifica aplicatia acesta trebuie sa fie pus in folderul 
    de baza si sa se numeasca "cities.txt"
***
## Limbaj
    JAVA -> SDK 15
***
## Realizator
:man_student:<a href="https://github.com/AlexNisulescu">Alex Nisulescu</a>
