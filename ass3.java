public class Dollar{
private int amount;
public Dollar(int amount) {
this.amount = amount;
}
public Dollar times(int multiplier) {
int resultantAmount = this.amount*multiplier;
return new Dollar(resultantAmount);
}
public Dollar dividedBy(int denominator) {
int resultantAmount = this.amount/denominator;
return new Dollar(resultantAmount);
}
@Override
public String toString() {
return "$"+this.amount;
}
@Override
public boolean equals(Object other) {
if(other instanceof Dollar && this.amount == ((Dollar) other).amount) {
return true;
}
return false;
}
}

import static org.junit.Assert.*;
import org.bson.Document;
import org.junit.Test;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
public class DollarTest {
@Test
public void testDollarDivision() {
// Given
Dollar ten = new Dollar(10);
// When
Dollar result = ten.dividedBy(2);
// Then
assertEquals(new Dollar(5), result); // You could change 5 to 4 to see
the build failure
}
@Test(expected=ArithmeticException.class)
public void testDollarDividedByZero() {
// Given
Dollar ten = new Dollar(10);
// When
ten.dividedBy(0);
}
}