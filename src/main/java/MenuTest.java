import org.junit.Test;

import static org.junit.Assert.*;

public class MenuTest {

    @Test
    public void getName() {
        Menu menu = new Menu();
        menu.setName("hanka");
        assertEquals("hanka", menu.getName());
    }

    @Test
    public void setPath() {
    }
}