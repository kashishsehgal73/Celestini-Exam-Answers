#include <Servo.h>.
#include <math.h>

const float trigPin = 7;
const float echoPin = 6;


long duration;
float distance;
int distance1,distance2;
Servo myServo; 
void setup() {
  pinMode(trigPin, OUTPUT); 
  pinMode(echoPin, INPUT); 

  Serial.begin(9600);
  myServo.attach(5); 
}
void loop() {

 
  for(int i=0;i<=90;i++){
    delay(10);
  myServo.write(i);
  
  distance = calculateDistance();
     distance1= distance * cos(i*3.142/180);
  distance2 = distance * sin(i*3.142/180);
   if(distance > 0)
  {
   Serial.print("Estimated Distance = ");

    Serial.print(distance);
     Serial.print(" & Angle = ");
    Serial.print(i);
     Serial.print(" & X = ");
    Serial.print(distance1);
     Serial.print(" & Y = ");
    Serial.print(distance2);
    Serial.println(" \n");
  }
  }
  for(int i=90;i>0;i--){
    delay(10);
  myServo.write(i);
  
  distance = calculateDistance();
   distance1= distance * sin(i*3.142/180);
  distance2 = distance * cos(i*3.142/180);
   if(distance > 0)
  {
   Serial.print("Estimated Distance = ");

    Serial.print(distance);
     Serial.print(" & Angle = ");
    Serial.print(i);
     Serial.print(" & X = ");
    Serial.print(distance1);
     Serial.print(" & Y = ");
    Serial.print(distance2);
    Serial.println(" \n");
  }
  }
 
}

float calculateDistance(){

float duration, distance;
  digitalWrite(trigPin, LOW); 
  delayMicroseconds(2);
 
  digitalWrite(trigPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(trigPin, LOW);
  
  duration = pulseIn(echoPin, HIGH);
  distance = (duration / 2) * 0.0344;
  
  if (distance >= 30 || distance <= 2){
    return 0;
  }
  else {
    return distance;
  }
}

