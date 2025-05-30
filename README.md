# 🧪 N11 Automation Test Suite

Bu proje, [n11.com](https://www.n11.com) web sitesinde temel kullanıcı akışlarını (giriş yapma, ürün arama, sepete ekleme ve çıkış yapma) TestNG ve Selenium WebDriver kullanarak otomatik test etmektedir.

---

## 📌 İçindekiler

- [🔧 Kullanılan Teknolojiler](#-kullanılan-teknolojiler)
- [📋 Test Senaryoları](#-test-senaryoları)
- [📁 Proje Yapısı](#-proje-yapısı)
- [⚙️ Kurulum Talimatları](#️-kurulum-talimatları)
- [📌 Notlar](#-notlar)

---

## 🔧 Kullanılan Teknolojiler

- **Java**
- **Selenium WebDriver**
- **TestNG**
- **Maven**
- **Page Object Model (POM)**
- **Git / GitHub**

---

## 📋 Test Senaryoları

| Test No | Test Adı         | Adımlar                                                                                           | Beklenen Sonuç                        |
|---------|------------------|---------------------------------------------------------------------------------------------------|----------------------------------------|
| TC_01   | Login Testi      | Giriş yap butonuna tıklanır → Email ve şifre girilir → Giriş yapılır                             | Kullanıcı başarılı şekilde giriş yapar |
| TC_02   | Ürün Arama Testi | "IPhone" aranır → + butonuna tıklanır → Sepetteki ürün sayısı kontrol edilir                    | Sepette 1 ürün görünür                 |
| TC_03   | Logout Testi     | "Hesabım" üzerine gelinir → "Çıkış Yap" butonuna tıklanır                                        | Kullanıcı çıkış yapar                  |

---

## 📁 Proje Yapısı

```bash
n11-automation/
├── src/
│   ├── test/
│   │   ├── java/
│   │   │   └── tests/
│   │   │       └── N11_test.java
│   │   └── resources/
│   │       └── configuration.properties
│   └── utils/
│       ├── ConfigurationReader.java
│       ├── Driver.java
│       └── ReusableMethods.java
├── pom.xml
└── README.md
Bu repoyu klonlayın:
git clone https://github.com/kullaniciAdi/n11-automation.git
cd n11-automation

Maven bağımlılıklarını yükleyin:
mvn clean install

configuration.properties dosyasına kendi email, şifre ve site URL bilgilerinizi girin:
src/test/resources/configuration.properties
n11=https://www.n11.com
email=ornek@mail.com
pw=sifreniz123

Testleri çalıştırmak için:
mvn test

📌 Notlar
ReusableMethods sınıfında scroll, visible bekleme gibi yardımcı metotlar yer alır.

N11_page sınıfı POM yaklaşımı ile web elementleri temsil eder.

SoftAssert kullanımı sayesinde tüm doğrulamalar tamamlandıktan sonra hata raporlanır.


