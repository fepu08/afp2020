# Rendszerterv

## 1 - Összefoglaló

A csapat feladata egy aquaparkokat üzemeltető cég munkáját segítő szoftver létrehozása. A megrendelő számára probléma, hogy a csúszdák  
használata jelenleg személyes rögzítéssel működik, illetve elektronikus számla kiállítására sincs lehetőség. Ezen problémákat hivatott kiváltani  
ez a rendszer, ahol a dolgozók kezelhetik a csúszdákat illetve a vendégeket és tudnak kiállítani elektronikus számlát is számukra, illetve a  
vendégeknek a csúszdák használatakor elég egy - a beléptetéskor kapott - órát a géphez érinteni.

## 2 - A projekt bemutatása

Ez a projektterv az aquapark számára készített vendég, csúszda és számlakezelő szoftver projektjét mutatja be, amely 2020.09.28-tól egészen  
2020.11.23-ig tart. A projekt célja, hogy egyszerűsítse, segítse az aquapark dolgozóit, illetve olcsóbbá és környezetbarátabbá  
tegye annak a működését.

#### 2.1 - Rendszerspecifikáció

A megrendelő kérése, hogy egyszerűbbé és gördülékenyebbé tegye a vendégei számára a csúszdák használatát, illetve a dolgozói számára  
a vendégek kezelését és a számlák kiállítását egy egyszerű és átlátható felületen. A megvalósításhoz több felület is szükséges:

- Egy felület a vendégek be- és kijelentkeztetésére,
- Egy, a csúszdák felvételére, módosítására illetve törlésére szolgáló felület,
- Egy felület a csúszda használatra,
- És egy felület a számla kiállítására.

##### 2.1.1 - Funkcionális követelmények

A megrendelő részéről:  

- Vendég be- és kiléptetési felület
- Csúszdák kezelésére való felület
- Csúszda használatot segítő felület
- Számla kiállítására szolgáló felület

###### 2.1.2 - Nem funkcionális követelmények

Online felületen fusson minden felület, illetve a csúszdák mellett szükséges gépek elhelyezése az órák használatához.

## 3 - Szervezeti felépítés és felelősség megosztás

A projekt megrendelője Szabó Péter, a cég vezetője. A projektet a következő, 5 főből álló csapat fogja végrehajtani: Besenyei Ferenc,  
Deák Ádám, Somogyi Dávid, Kerepesi Gergő és Soós István.

#### 3.1 - Projektcsapat

A projekt a következő emberekből áll:

|                                            |                             Név                              |                         Elérhetőség                          |
| :----------------------------------------: | :----------------------------------------------------------: | :----------------------------------------------------------: |
|                 Megrendelő                 |                         Szabó Péter                          |                   szabo.peter@aquapark.com                   |
|             Projekt menedzser              |                       Besenyei Ferenc                        |                 besenyei.ferenc@aquapark.com                 |
| Adatbázisért és adatkapcsolatokért felelős |                          Deák Ádám                           |                    deak.adam@aquapark.com                    |
|     Felhasználói felületekért felelős      |                        Kerepesi Gergő                        |                 kerepesi.gergo@aquapark.com                  |
|  A rendszer működési logikájáért felelős   |                        Somogyi Dávid                         |                  somogyi.david@aquapark.com                  |
|          Dokumentációért felelős           | Somogyi Dávid<br />Deák Ádám<br />Kerepesi Gergő<br />Soós István | somogyi.david@aquapark.com  <br />deak.adam@aquapark.com<br />kerepesi.gergo@aquapark.com<br />soos.istvan@aquapark.com |
|           Prezentációért felelős           |                         Soós István                          |                   soos.istvan@aquapark.com                   |

## 4 - A munka feltételei

#### 4.1 - Munkakörnyezet

A projektet a csapat Java (Spring), illetve JavaScript (React) nyelveken írja.

#### 4.2 - Rizikómenedzsment

Betegség (közepes): a projekt elkészülését késleltetheti, ha egy csapattag váratlanul megbetegedik. Ennek következtében nem tudunk rendszeres meetinget tartani. (Valószínűség: közepes/ hatás: közepes)

Egy számítógép meghibásodása (nagy): előfordulhat, hogy egy csapattag számítógépe ismeretlen okokból meghibásodhat. Ebből kifolyólag meg kell osztani az erőforrásokat, amely kellemetlen szituációkat eredményezhet. (Valószínűség: kicsi/ hatás: nagy).

Adatveszteség (nagy): adatveszteség esetén, a csapat nagyon nagy problémába kerülhet. Sok minden múlhat, ha elvesztjük az adatainkat, főleg ha nem készítünk biztonsági mentést. (Valószínűség: kicsi / hatás: nagy).

Projekttag a kiosztott feladatot nem hajlandó elvégezni (közepes). (Valószínűség: kicsi / hatás: közepes).

## 5 - Jelentések

#### 5.1 - Munka menedzsment

A munkát Besenyei Ferenc menedzseli. A menedzser feladatai: állandó kapcsolattartás a csapattagok között. Kommunikáció a megrendelő között. A kommunikáció a vírushelyzetre való tekintettel kizárólag online (Discord, Facebook) történik. A megrendelővel a kommunikáció e-mail-en, illetve 
Discordon keresztül történik. A menedzser további feladatai közé tartozik, hogy biztosítja a kapcsolatot két csapattag között is, valamint folyamatosan tájékozódnia kell, hogy az adott csapattag, hogy áll a számára kiadott feladattal.

#### 5.2 - Csoportgyűlések

Minden csoportgyűlés hétfőnként 17.20-kor történik Discordon, egyéb időpontokban ha szükséges.

#### 5.3 - Minőségbiztosítás

Az elkészült terveket a terveken nem dolgozó csapattársak közül átnézik, hogy megfelel-e a specifikációnak és az egyes diagramtípusok összhangban vannak-e egymással. A meglévő rendszerünk helyes működését a prototípusok bemutatása előtt a tesztelési dokumentumban leírtak végrehajtása alapján ellenőrizzük és összevetjük a specifikációval, hogy az elvárt eredményt kapjuk-e. További tesztelési lehetőségek: unit tesztek írása az egyes modulokhoz vagy a kód közös átnézése (code review) egy, a vizsgált modul programozásában nem résztvevő csapattaggal. Szoftverünk minőségét a végső leadás előtt javítani kell a rendszerünkre lefuttatott kódelemzés során kapott metrikaértékek és szabálysértések figyelembevételével.

Az alábbi lehetőségek vannak a szoftver megfelelő minőségének biztosítására:

● Specifikáció és tervek átnézése (kötelező)

● Teszttervek végrehajtása (kötelező)

● Unit tesztek írása (választható)

● Kód átnézése (választható)

#### 5.4 - Átadás, eredmények elfogadása

A projekt eredményeit Szabó Péter fogja elfogadni. A projektterven változásokat csak Szabó Péter írásos kérés esetén, Szabó Péter engedélyével lehet tenni. A projekt eredményesnek bizonyul, ha specifikáció helyes és határidőn belül készül el.

#### 5.5 - Státuszjelentés

Minden leadásnál a projektmenedzser jelentést tesz a projekt haladásáról, és ha szükséges változásokat indítványoz a projektterven. Ezen kívül a megrendelő felszólítására a menedzser 3 munkanapon belül köteles leadni a jelentést. A gyakorlatvezetővel folytatott csapatmegbeszéléseken a megadott sablon alapján emlékeztetőt készít a csapat, amit a következő megbeszélésen áttekintenek és felmérik az eredményeket és teendőket. Továbbá gazdálkodnak az erőforrásokkal és szükség esetén a megrendelővel egyeztetnek a projektterv módosításáról.

## 6 - A munka tartalma

#### 6.1 Tervezett szoftverfolyamat modell és architektúra

A projectben részvevők az strukturális modellt választva valósítják meg a kívánt programot.

A csapat Java, illetve JavaScript nyelveken valósítja meg a megrendelő által kérvényezett programot, amelyben fontos szerepet játszanak:

\- adatbázistáblák

\- grafikus felület

\- logikai kapcsolat

#### 6.2 - Átadandók és határidők

A főbb átadandók és határidők a projekt időtartama alatt a következők:

|                Neve                 | Határideje |
| :---------------------------------: | :--------: |
|       Projektterv és útmutató       | 2020-09-28 |
| UML és adatbázis tervek és bemutató | 2020-10-05 |
|     Első prototípus és bemutató     | 2020-10-26 |
|      Kész projekt és bemutató       | 2020-11-23 |

## 7 - Feladatlista

Az online webáruház project 2020. szeptember 28-án indult. A következőkben a tervezett feladatok részletes összefoglalása található:

#### 7.1 - Projektterv

Ennek a feladatnak az a célja, hogy készítsünk egy olyan dokumentációt ahol részletesen le van jegyzetelve, hogy például milyen nyelven írjuk a projektet, mik a rizikótényezők, illetve, hogy ki milyen feladatban fog részt venni.

\- Felelős: Besenyei Ferenc, Deák Ádám

\- Tartam: 1 hét

#### 7.2 UML és adatbázis tervek

A feladat célja, hogy elkészüljenek az adatbázistervek illetve az adatbázist könnyen átlátható modellje.

Részfeladatai a következők:

##### 7.2.1 Adatbázis struktúra

\- Felelősök: Deák Ádám, Somogyi Dávid

\- Tartam: 2 nap

##### 7.2.2 Képernyőtervek

\- Felelősök: Kerepesi Gergő, Soós István

\- Tartam: 2 nap

##### 7.2.3 Tesztesetek, teszttervek

\- Felelősök: Deák Ádám

\- Tartam: 2 nap

##### 7.2.4 Bemutató elkészítése és bemutatása

\- Felelősök: Besenyei Ferenc, Deák Ádám, Somogyi Dávid, Kerepesi Gergő, Soós István

\- Tartam: 3 nap

#### 7.3 Prototípus I. (modellfüggő)

Ennek a feladatnak az a célja, hogy egy bemutatásra alkalmas, működő oldal el legyen készítve.

Részfeladatai a következők:

##### 7.3.1 Prototípus

\- Felelősök: Somogyi Dávid, Deák Ádám

\- Tartam: 3 nap

##### 7.3.2 Tesztelési dokumentum

\- Felelősök: Kerepesi Gergő, Soós István

\- Tartam: 4 nap

##### 7.3.3 Bemutató elkészítése és bemutatása

\- Felelősök: Besenyei Ferenc, Deák Ádám, Somogyi Dávid, Kerepesi Gergő, Soós István

\- Tartam: 4 nap

## 8 -  Projekt költségvetés

#### 8.1 - Átvétel

|       Név       |  1. leadás  |    2. leadás     |   3. leadás   | Össz. |
| :-------------: | :---------: | :--------------: | :-----------: | :---: |
|                 | Projektterv | UML és adatbázis | I. Prototípus |       |
| Besenyei Ferenc |     14      |        24        |      22       |  60   |
|    Deák Ádám    |     14      |        24        |      22       |  60   |
|  Somogyi Dávid  |     14      |        24        |      22       |  60   |
| Kerepesi Gergő  |     14      |        24        |      22       |  60   |
|   Soós István   |     14      |        24        |      22       |  60   |

Eger, 2020. 11. 13



​							Aláírás																																													Aláírás

​					Az átadó részéről																																								Az átvevő részéről