# Funkcionális specifikáció

### A jelenlegi helyzet

Egy több aquaparkot is üzemeltető cég felkeresett bennünket, mivel jelenleg a csúszdák használatának  
követésére és a számlák kiállítására a cég semmilyen modern rendszerrel nem rendelkezik, ez pedig jelentősen  
megnehezíti, lassítja és költségessé teszi több park működtetését. A cég vezetője ezért keresett fel minket.  

### A kívánt rendszer

Felkérést kaptunk egy aquaparkban a dolgozók által használt szoftver fejlesztésére, hogy megkönnyítsük, felgyorsítsuk  
a dolgozók munkáját és csökkentsük a parkok kiadásait. A rendszere JAVA nyelven kerül megírásra és weblapként  
funkcionál. Minden dolgozó hozzáférhet a legtöbb funkcióhoz, a legfontosabb a csúszdák kezelése. A vendégek belépéskor  
kapnak egy órát, amit minden csúszdahasználatkor le kell olvasni a csúszda mellett megtalálható gépnél, távozáskor pedig  
kapnak lehetőségük van kapni  elektronikusan is számlát, amelyet a megadott e-mail címre küld el a cég. 

### Elvárt működés

Amikor a dolgozó az oldalt megnyitja, lehetősége van létrehozni új vendégeket a beléptetéskor, a megfelelő órát pedig át kell  
nyújtania a vendégnek.  A vendég a csúszdák használata előtt csupán használja az órát a kihelyezett gépnél.  
A dolgozók képesek új csúszdát létrehozni, szerkeszteni, illetve törölni azokat és számlát előállítani, illetve elektronikus számlát  
kiállítani, amelyen a vendég csúszda használatai láthatók, illetve a fizetendő összeg is.

### Szükséges funkciók listája

|  Modul   |  ID  |                   Név                    |                            Leírás                            |
| :------: | :--: | :--------------------------------------: | :----------------------------------------------------------: |
| Backend  |  F1  |                Adatbázis                 | Az adatbázis tárolja az alkalmazás által használt adatokat.  |
| Backend  |  F2  |                Beléptetés                | Egy vendég beléptetésekor egy egyedi azonosító eszközt kap.  |
| Backend  |  F3  |            Csúszda használata            |             Egy csúszda használata vendég által.             |
| Backend  |  F4  | Összes használatban lévő óra lekérdezése |  A dolgozók lekérdezhetik az összes használatban lévő órát.  |
| Backend  |  F5  |             Kijelentkeztetés             | A vendég az aquapark elhagyásakor visszaadja az egyedi azonosítóját. |
| Frontend |  F6  |          Vendég beléptető oldal          |            A vendég beléptetésére használt oldal.            |
| Frontend |  F7  |         Csúszda használat oldal          |            A csúszda használatára használt oldal.            |
| Frontend |  F8  |        Csúszda létrehozása oldal         |           A csúszda létrehozására használt oldal.            |
| Frontend |  F9  |         Csúszda módosítása oldal         |            A csúszda módosítására használt oldal.            |

### Jogszabályok

- „4/A. Számlázó programok adatszolgáltatása
  **13/A.** **§** (1) A számlázó programnak a gép-gép interfész használatához szükséges azonosító adatok megküldése mellett a kiállított számla, számlával egy tekintet alá eső okirat legalább Áfa tv. szerinti kötelező adattartalmát a számla, számlával egy tekintet alá eső okirat kiállításakor azonnal, XML-formátumban, az állami adó- és vámhatóság közleményében meghatározott módon és adatszerkezetben, elektronikus úton továbbítania kell az állami adó- és vámhatóság részére.
  
- **13/B. § (**1) Ha a számlázó program által kiállított számla, számlával egy tekintet alá eső okirat adatait fogadó elektronikus rendszerben üzemzavar történik, az állami adó- és vámhatóság az üzemzavarról és az üzemzavar elhárítását követően annak kezdő és megszűnési időpontjáról haladéktalanul közleményt tesz közzé honlapján.

- A vállalkozás az általa kínált fizetési mód igénybevétele után fizetendő díjat meghaladó további díjat nem terheljenek a vendégekre. 

- **9. §** (1) A számlázó programot fejlesztőként, forgalmazóként értékesítő adóalany köteles az általa értékesített számlázó programot annak neve, azonosítója, a vevő neve és az értékesítés időpontja szerint nyilvántartani.

  (2) A számlázó program fejlesztője, forgalmazója a számlázó programot kizárólag adóalanynak értékesítheti, aki vagy amely köteles az értékesítést megelőzően adóalanyiságát igazolni. A számlázó program fejlesztője, forgalmazója köteles a számlázó program értékesítéséről kibocsátott számlán feltüntetni a számlázó programot beszerző adóalany adószámát.

  **13/B. §** (1) Ha a számlázó program által kiállított számla, számlával egy tekintet alá eső okirat adatait fogadó elektronikus rendszerben üzemzavar történik, az állami adó- és vámhatóság az üzemzavarról és az üzemzavar elhárítását követően annak kezdő és megszűnési időpontjáról haladéktalanul közleményt tesz közzé honlapján.

- **14. §** Ha a felek az elektronikus számlát elektronikus adatcsererendszerben (a továbbiakban: EDI) elektronikus adatként kívánják létrehozni és továbbítani, az EDI alkalmazására és használatára az Áfa tv. 175. § (3) bekezdés *a)* pontjában előírt előzetes és írásos megállapodási kötelezettségüknek az 1. mellékletben meghatározott szerződés megkötésével is eleget tehetnek.

- **18. §** (1) Az elektronikus formában megőrzött számla és nyugta ellenőrzése során az adóalany köteles az adóhatóság részére

  *a)* a helyszínen biztosítani a számla és a nyugta olvashatóságához szükséges technikai eszközöket.

### A prototípus bemutatása

A vevővel való találkozáskor bemutatásra került az oldal prototípusa. Ekkor tesztelte az eddig elkészült funkciók használatát és elmondta  
észrevételeit, ötleteit és tanácsait a termékkel kapcsolatban. Folytatódhat az termék további fejlesztése, a megrendelő észrevételei alapján,  
illetve a csapat-megbeszélés kiegészítésével.

### Szótár

- **backend**: adat-hozzáférési réteg a szoftverben.
- **frontend**: felület a felhasználó és a backend között
- **kliens:** szoftver, amely hozzáfér a szolgáltatáshoz