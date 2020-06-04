/*
from the upper directory call:
 javac -cp .:./junit-platform-console-standalone-1.5.2.jar stacksNqueues/QueueTest.java
java -jar ./junit-platform-console-standalone-1.5.2.jar -cp . -c stacksNqueues.QueueTest
*/

package stacksNqueues;


import org.junit.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QueueTest {
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {

  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {

  }

  /**
    Con esta prueba verificaremos que jUnit este funcionando  
  */
  @Test
  public void pruebaJUnit() {

    assertTrue(true);
  }

  @Test 
  public void createQueueAndPrintValues() {
    Queue<Integer> q = new Queue<Integer>();
    q.add(3);
    q.add(2);
    int r = q.remove();
    assertEquals(3,r);
  }
}