# Követelmény specifikáció

### A jelenlegi helyzet

Egy több aquaparkot is üzemeltető cég felkeresett bennünket, mivel jelenleg a csúszdák használatának  
követésére és a számlák kiállítására a cég semmilyen modern rendszerrel nem rendelkezik, ez pedig jelentősen  
megnehezíti, lassítja és költségessé teszi több park működtetését. A cég vezetője ezért keresett fel minket.  

### A kívánt rendszer

Felkérést kaptunk egy aquaparkban a dolgozók által használt szoftver fejlesztésére, hogy megkönnyítsük, felgyorsítsuk  
a dolgozók munkáját és csökkentsük a parkok kiadásait. A rendszere JAVA nyelven kerül megírásra és weblapként  
funkcionál. Minden dolgozó hozzáférhet a legtöbb funkcióhoz.  A vendégek belépéskor kapnak egy órát, amit minden  
csúszdahasználatkor le kell olvasni a csúszda mellett megtalálható gépnél.

### Elvárt működés

Amikor a dolgozó az oldalt megnyitja, lehetősége van létrehozni új vendégeket a beléptetéskor, a megfelelő órát pedig át kell  
nyújtania a vendégnek.  A vendég a csúszdák használata előtt csupán használja az órát a kihelyezett gépnél.  
A dolgozók képesek új csúszdát létrehozni, szerkeszteni, illetve törölni azokat és számlát előállítani.

### Szükséges funkciók listája

|  Modul   |  ID  |            Név            |                           Leírás                            |
| :------: | :--: | :-----------------------: | :---------------------------------------------------------: |
| Backend  |  F1  |         Adatbázis         | Az adatbázis tárolja az alkalmazás által használt adatokat. |
| Frontend |  F2  |  Vendég beléptető oldal   |           A vendég beléptetésére használt oldal.            |
| Frontend |  F3  |  Csúszda használat oldal  |           A csúszda használatára használt oldal.            |
| Frontend |  F4  | Csúszda létrehozása oldal |           A csúszda létrehozására használt oldal.           |
| Frontend |  F5  | Csúszda módosítása oldal  |           A csúszda módosítására használt oldal.            |

### Jogszabályok

- „4/A. Számlázó programok adatszolgáltatása
  **13/A.** **§** (1) A számlázó programnak a gép-gép interfész használatához szükséges azonosító adatok megküldése mellett a kiállított számla, számlával egy tekintet alá eső okirat legalább Áfa tv. szerinti kötelező adattartalmát a számla, számlával egy tekintet alá eső okirat kiállításakor azonnal, XML-formátumban, az állami adó- és vámhatóság közleményében meghatározott módon és adatszerkezetben, elektronikus úton továbbítania kell az állami adó- és vámhatóság részére.
- **13/B. § (**1) Ha a számlázó program által kiállított számla, számlával egy tekintet alá eső okirat adatait fogadó elektronikus rendszerben üzemzavar történik, az állami adó- és vámhatóság az üzemzavarról és az üzemzavar elhárítását követően annak kezdő és megszűnési időpontjáról haladéktalanul közleményt tesz közzé honlapján.
- A vállalkozás az általa kínált fizetési mód igénybevétele után fizetendő díjat meghaladó további díjat nem terheljenek a vendégekre.  

### Szótár

- **backend**: adat-hozzáférési réteg a szoftverben.
- **frontend**: felület a felhasználó és a backend között