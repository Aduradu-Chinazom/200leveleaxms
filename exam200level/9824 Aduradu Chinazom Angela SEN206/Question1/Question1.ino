#include <LiquidCrystal.h>

// Initialize the library with the numbers of the interface pins
LiquidCrystal lcd(7, 6, 5, 4, 3, 2);

const int buttonPin = 9; 
const int buttonState = 0; 
int lastButtonState = 0;
int counter = 0;

void setup() {
  lcd.begin(16, 2); // LCD's number of columns and rows
  lcd.print("My LCD Counter");

  pinMode(buttonPin, INPUT);//_PULLUP
}

void loop() {
  int reading = digitalRead(buttonPin);

  if (reading != lastButtonState) {
    if (reading == LOW) {
      counter++;
      lcd.setCursor(0, 1);
      lcd.print("Count: ");
      lcd.print(counter);
    }
    delay(500); 
  }

  lastButtonState = reading;
}
