# Követelmény specifikáció

## Bevezetés 
Weboldalunk célja, hogy az aquaparkban lévő csúszdák használatát és árait könnyen nyomon lehessen követni egy új eszköz segítségével.
Ezt az új eszközt, amit egész nap viselniük kell a vendégeknek a bejelentkezés során kapják meg az ott dolgozóktól így ennek segítségével
mindegyik csúszda érzékelni tudja azok használatát. Az eszköz minden csúszás után regisztrálja a csúszda árát, illetve hányszor volt használva.
Kijeletkezéskor a vendég egy részletes számlát kap az általa használt csúszdákról. A dolgozók ezekből az adatokból napi vagy havi 
összesítést tudnak belőle készíteni.

## Jelenlegi helyzet
Jelenleg minden csúszda mellett egy-egy dolgozónak ott kell lennie, hogy felírja éppen ki és hányszor csúszott.

Jelenlegi rendszer problémái:
- Lassú, időigényes
- Sok embert igényel
- Nem megbízható
- A dolgozók ebédszünetekor nem elérhetők a csúszdák
- Körülményes a statisztika készítés
- Új csúszdák esetén több dolgozóra van szükség

## Vágyálom rendszer
- Az új rendszer célja a dolgozók munkájának megkönnyítése ezáltal a vendégek gyorsabban használatba vehetik a csúszdákat 
és átláthatóbb statisztika készíthető.

- A szoftver lehetővé teszi, hogy távozáskor a vendég egy részletes összesítést kapjon a napi csúszda használatáról.

- Későbiekben a szoftver könnyen bővíthető új csúszdák telepítése esetén.

- A vendégek elektronikusan és papír formájában is kérhetik a számlát.

## Funkcionális követelmény
**Dolgozók számára elérhető funkciók:**
- Vendég belépetése és kijelentkeztetése
- Összes használatban lévő óra lekérdezése
- Adott vendég csúszda használatának lekérdezése
- Napi vagy havi statisztika elkészítése a csúszdákról
- Vendég számára számla előállítása

**Vendég számára elérhető funkciók:**
- Saját statisztika lekérdezése
- Jelenlegi költségek lekérdezése

## Követelmény lista
- Minden csúszdát a megfelelő érzékelővel kell felszerelni
- Bejelentkezéskor minden vendégnek órát kell adni
- A szabad órák nyomonkövetése
- Minden óra egyedi és a nap során többször felhasználható más vendég által
- A nap végén minden órát vissza kell adni
- Óra visszaadását követően a számlát ki kell fizetni és az óra adatait törölni kell
