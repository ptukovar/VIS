# Lofi Wear
## WHY?
Z důvodu větší tržby a jednoduššího výběru produktů z domova.
## WHAT?
Zdigitalizování existující kamenné prodejny second hand. Možnost zakoupení produktů online.
## WHO?
* Admin
* Prodejce
* Zákazník
## WHERE?
* Webová stránka
* Mobilní aplikace
## WHEN?
Když lidé budou chtít koupit nebo prodat nějaký produkt.
## HOW?
* Fresh Implementation

# Usecase

![image](https://user-images.githubusercontent.com/53978671/205498305-f59e4be4-4813-4c0f-a8d9-06a21b030f6f.png)

UC2: Parametry</br>
•	Název: Login</br>
•	Kontext: Přihlášení uživatele do systému.</br>
•	Primary actor: User, Reseller, Administrator</br>
•	Stakeholders and Interests: Administrator</br>
•	Precondition: Uživatel musí mít založený účet v databázi. Následně musí zadat správné jméno a heslo.</br>
![image](https://user-images.githubusercontent.com/53978671/205499372-663e8d4b-988a-43d4-905b-43180ba44c6d.png)

UC3: Parametry</br>
•	Název: Add products</br>
•	Kontext: Přidání nové položky do databáze.</br>
•	Primary actor: Reseller</br>
•	Stakeholders and Interests: Administrator</br>
•	Precondition: Musí být funkční databáze a uživatel musí být alespoň reseller.</br>
![image](https://user-images.githubusercontent.com/53978671/205499400-bc2cfd53-43e0-4731-944b-0e8876463968.png)

UC4: Parametry</br>
•	Název: Search products </br>
•	Kontext: Vyhledání zadaného produktu v databázi</br>
•	Primary actor: Buyer</br>
•	Stakeholders and Interests: Reseller, Administrator</br>
•	Precondition: Musí být funkční databáze</br>
![image](https://user-images.githubusercontent.com/53978671/205499408-10b577ec-c94f-4882-a5a7-d86a2a477938.png)

# Návrh domenového modelu
![image](https://user-images.githubusercontent.com/53978671/205500388-7b2d1d37-145b-4e62-9885-e3537462be98.png)

# Velikosti entit a jejich množství
• Uživatel</br>
• Velikost záznamu: 2 kB</br>
• Počet se zvýši po úspěšné registraci</br>
• Celkem potřebného prostoru zhruba: 400 kB – 20 MB</br>

• Objednávka</br>
• Velikost záznamu: 1 kB</br>
• Počet se zvýši po úspěšném objednání produktů</br>
• Celkem potřebného prostoru zhruba: 200 kB – 10 MB</br>

• Produkt</br>
• Velikost záznamu: 1 MB</br>
• Počet se zvýši po přidání nového produktu</br>
• Celkem potřebného prostoru zhruba: 1 MB – 200 MB</br>

• Platba</br>
• Velikost záznamu: 3 kB</br>
• Počet se zvýši po provedení platby</br>
• Celkem potřebného prostoru zhruba: 300 kB – 15 MB</br>

# Wireframe
![map](https://user-images.githubusercontent.com/53978671/205502051-4e3f277a-3024-4040-97c0-a48236a08d21.png)


# Sekvenční diagram
![image](https://user-images.githubusercontent.com/53978671/205596770-b98a8571-782a-40fc-a69e-34e45e7f9af5.png)

# Diagram komponent
![image](https://user-images.githubusercontent.com/53978671/205696420-e65cfe56-85b9-4075-83a8-e23055c1da7e.png)

