# Követelmény specifikáció

## Bevezetés 
Weboldalunk célja, hogy az aquaparkokban lévő csúszdák használatát és árait könnyen nyomon lehessen követni egy új eszköz segítségével.
Ezt az új eszközt, amit egésznap viselniük kell a vendégeknek a bejelentkezés során kapjákmeg az ott dolgozóktól így ennek segítségével
mindegyik csúszda érzékelni tudja. Az eszköz minden csúszás után regisztrálja a csúszda árát, illetve hanyadjára használták azt.
Kijeletkezéskor a vendég egy részletes számlát kap az általa használt csúszdákról. A dolgozók ezekből az adatokból napi vagy éppen havi 
összesítést tudnak belőlle készíteni.

## Jelenlegi helyzet
Jelenleg minden csúszda mellett egy-egy dolgozónak ott kell lennie, hogy felírja éppen ki és hányszor csúszott.

Jelenlegi rendszer problémái:
- Lassú
- Sok embert igényel
- Nem megbízható
- A dolgozók ebédszünetekor nem elérhetők a csúszdák
- Körülményes a statisztika készítés
- Új csúszdák esetén több dolgozóra van szükség

## Vágyálom rendszer
- Az új rendszer célja a dolgozók munkályának megkönnyítése ezáltal a venégek gyorsabban használatba vehetik a csúszdákat 
és átláthatóbb statisztika készíthető.

- A szoftver lehetővé teszi, hogy távozáskor a vendég egy részletes összesítést kapjon a napi csúszda használatáról.

- Későbiekben a szofver könnyen bővíthető új csúszdák telepítése esetén.

- A vendégek elektornikusan és papír formájában is kérhetik a számlát.

## Funkcionális követelmény
**Dolgozók számára elérhető funkciók:**
- Vendég belépetése és kijelentkeztetése
- Összes használatban lévő óra lekérdezése
- Adott vendég csúszda használatának lekérdezése
- Napi vagy havi statisztika elkészítése
- Vendég számára számla előállítása

**Vendég számára elérhető funkciók:**
- Saját statisztika lekérdezése
- Jelenlegi kölcségek lekérdezése

## Követelmény lista
- Minden csúszdád a megfelelő érzékelővel felszerelni
- Bejelentkezéskor az órákat kiosztani a vendégeknek
- A szabad órák nyomonkövetése
- Minden óra egyedi és a nap során többször felhasználható legyen
- A napvégén minden órát vissza kell adni
- Óra vissza adását követően a számlát kifizetni és annak adatait lenullázni