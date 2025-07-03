const int segmentPins[] = {7, 8, 9, 10, 11, 12, 13};
const int tensPins[] = {5, 4, 3, 2, A0, A1, A2}; 
const int dpPin = 9;
const int cc1 = A3; 
const int cc2 = A4;

const byte numbers[10][7] = {
  {1, 1, 1, 1, 1, 1, 0}, //0
  {0, 1, 1, 0, 0, 0, 0}, 
  {1, 1, 0, 1, 1, 0, 1},
  {1, 1, 1, 1, 0, 0, 1}, 
  {0, 1, 1, 0, 0, 1, 1}, 
  {1, 0, 1, 1, 0, 1, 1}, 
  {1, 0, 1, 1, 1, 1, 1}, 
  {1, 1, 1, 0, 0, 0, 0}, 
  {1, 1, 1, 1, 1, 1, 1}, 
  {1, 1, 1, 1, 0, 1, 1}  // 9
};

void setup() {
  for (int i = 0; i < 7; i++) {
    pinMode(segmentPins[i], OUTPUT);
    pinMode(tensPins[i], OUTPUT);
  }
  pinMode(dpPin, OUTPUT);
  pinMode(cc1, OUTPUT);
  pinMode(cc2, OUTPUT);
}

void loop() {
  // Count from 0 to 99
  for (int i = 0; i < 100; i++) {
    int tens = i / 10;
    int units = i % 10;

    displayNumber(tens, true);
    delay(5); 

    displayNumber(units, false);
    delay(5);

    delay(5000);
  }
}

void displayNumber(int number, bool tensPlace) {
  int *segmentPinsToUse = (tensPlace) ? tensPins : segmentPins;    // Select display based on tensPlace
  int ccPin = (tensPlace) ? cc2 : cc1;

  // Turn off the display
  digitalWrite(cc1, HIGH);
  digitalWrite(cc2, HIGH);

  for (int i = 0; i < 7; i++) {
    digitalWrite(segmentPinsToUse[i], numbers[number][i]);
  }

  // Turn on the display
  digitalWrite(ccPin, LOW);
}
