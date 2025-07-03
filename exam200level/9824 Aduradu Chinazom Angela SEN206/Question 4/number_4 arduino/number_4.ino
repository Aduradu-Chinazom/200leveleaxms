#include <LiquidCrystal.h>
const int rs=12, e=11, d4=10, d5=9, d6=8, d7=7;
LiquidCrystal lcd(rs, e, d4, d5, d6, d7);
const int DHT22 = A0;
int temperature = 0;
float realTemp = 0;
const int led = 2;
void setup() {
  lcd.begin(16,2);
  lcd.print("Temp.Project");
  delay(2000);
  pinMode(DHT22, INPUT);
  pinMode(led, OUTPUT);
}

void loop() {
  temperature = analogRead(DHT22);
  realTemp = (((float)temperature*5.0)/1023.0)*102.0;
  lcd.clear();
  lcd.print("Temp.Value=");
  lcd.print(realTemp);
  delay(500);
  if (realTemp > 50.0) {
    digitalWrite(led, HIGH);
  } else {
    digitalWrite(led, LOW);
  }

}
