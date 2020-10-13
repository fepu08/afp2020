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



| ID   |                   Megnevezés                   |                            Leírás                            |
| :--- | :--------------------------------------------: | :----------------------------------------------------------: |
| F1   |                   Beléptetés                   | Egy vendég beléptetésekor egy egyedi azonosító eszközt kap, amely azonosítani fogja őt minden csúszda használatakor. Egy azonosító eszköz többször is használatba vehető egy nap más vendég által. |
| F2   |               Csúszda használata               | Csúszdákat csak azonosítóval ellátott vendég használhat. Az ár minden csúszdahasználatkor az azonosító eszközhöz tartozó számlát terheli. |
| F3   |    Összes használatban lévő óra lekérdezése    | A dolgozók képesek a jelenleg összes használatban lévő órát lekérdezni, a hozzájuk tartozó adatokkal együtt. |
| F4   | Adott vendég csúszda használatának lekérdezése | A dolgozók lekérdezhetik egy bizonyos vendéghez tartozó adatokat, számlát és a csúszdák használatát. |
| F5   |       Napi/havi statisztika lekérdezése        | A dolgozók számára elérhető, napi vagy havi statisztika lekérdezése a csúszdák használatára vonatkozóan. |
| F6   |         Saját statisztika lekérdezése          |     A vendég képes lekérdezni saját csúszdahasználatait.     |
| F7   |        Jelenlegi költségek lekérdezése         |  A vendég lekérdezheti az összes fizetési kötelezettségét.   |
| F8   |       Vendég számára számla előállítása        | Az Aquapark elhagyása előtt a vendég kap egy részletes számlát a csúszdahasználatáról és a fizetési kötelezettségeiről. A számlát a vendég kifizeti. |
| F9   |                 Kijelentkezés                  | A vendég az Aquapark elhagyásakor visszaadja az egyedi azonosítóját, amelyet egy másik vendég újra megkaphat. |



## Adatstruktúra



#### F1 - Beléptetés

```
{
    user_id: int,
    watch_id: uuid,
    transaction_id: uuid
    timestamp: dateTime
}
```

#### F2 - Csúszda használata 

```
{
    transaction_id: uuid,
    user_id: int,
    watch_id: uuid,
    slide_id: int,
    timestamp: dateTime
}
```

#### F3 - Összes használatban lévő óra lekérdezése

```
{
    user_id: int,
    watch_id: uuid
    total_watch: int
}
```

#### F4 - Adott vendég csúszda használatának lekérdezése

```
{
    user_id: int,
    watch_id: uuid,
    usages: [
        {
            user_id: int,
            watch_id: uuid,
            slide_id: int,
            timestamp: dateTime
        }, ...
    ]
}
```

#### F5 - Napi/havi statisztika lekérdezése

```
{
    total_income: int,
    statistics: [
        {
            slide_id: int,
            slide_income: int,
            usages: [
                {
                    watch_id: uuid,
                    timestamp: dateTime
                }, ...
            ]
        }, ...
    ]
}
```

#### F6 - Saját statisztika lekérdezése

```
{
    user_id: int,
    watch_id: uuid,
    usages: [
        {
            user_id: int,
            watch_id: uuid,
            slide_id: int,
            timestamp: dateTime
        }, ...
    ]
}
```

#### F7 - Jelenlegi költségek lekérdezése

```
{
    user_id: int,
    watch_id: uuid,
    transaction_id: uuid,
    usages: [
        {
            user_id: int,
            watch_id: uuid,
            timestamp: dateTime
            slide_price: int
        }, ...
    ]
}
```

#### F8 - Vendég számára számla előállítása

```
{
    transaction_id: uuid,
    receipt_id: int,
    total_price: int,
    slide_usages: [
        {
            user_id: int,
            watch_id: uuid,
            timestamp: dateTime,
            slide_id: int,
        }, ...
    ]
}
```

#### F9 - Kijelentkezés

```
{
    watch_id: uuid,
    user_id: int
}
```



## Követelmény lista
- Minden csúszdát a megfelelő érzékelővel kell felszerelni
- Bejelentkezéskor minden vendégnek órát kell adni
- A szabad órák nyomon követése
- Minden óra egyedi és a nap során többször felhasználható más vendég által
- A nap végén minden órát vissza kell adni
- Óra visszaadását követően a számlát ki kell fizetni és az óra adatait törölni kell

