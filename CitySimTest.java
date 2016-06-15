package testing;
import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.Random;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import org.mockito.*;

public class CitySimTest {
	
	@SuppressWarnings("unchecked")
	@Mock
	LinkedList<Integer> mockedLinkedList = Mockito.mock(LinkedList.class);
	
	@Before
	public void setUp() throws Exception {
		// If you use @Mock, you need to do this
		MockitoAnnotations.initMocks(mockedLinkedList);
		
	}

	@After
	public void tearDown() throws Exception {
		// any necessary teardown - none needed here
	}	
	
	
	//A Blogger dislikes every location - following 4 tests
	//Create a new Blogger
	//Ensure the prefersLocation method returns false for every location
	@Test
	public void testBlogger1() {
        Blogger dummy = new Blogger();
        assertFalse(dummy.prefersLocation(Location.ThePoint));
	}
	
	@Test
	public void testBlogger2() {
        Blogger dummy = new Blogger();
        assertFalse(dummy.prefersLocation(Location.CathedralOfLearning));
	}
	
	@Test
	public void testBlogger3() {
        Blogger dummy = new Blogger();
        assertFalse(dummy.prefersLocation(Location.Downtown));
	}
	
	@Test
	public void testBlogger4() {
        Blogger dummy = new Blogger();
        assertFalse(dummy.prefersLocation(Location.SquirrelHill));
	}
	
	//A Professor likes every location - following 4 tests
	//Create a new Professor
	//Ensure the prefersLocation method returns true for every location
	@Test
	public void testProfessor1() {
	    Professor dummy = new Professor();
	    assertTrue(dummy.prefersLocation(Location.ThePoint));
	}
		
	@Test
	public void testProfessor2() {
		Professor dummy = new Professor();
		assertTrue(dummy.prefersLocation(Location.CathedralOfLearning));
	}
		
	@Test
	public void testProfessor3() {
		Professor dummy = new Professor();
		assertTrue(dummy.prefersLocation(Location.Downtown));
	}
		
	@Test
	public void testProfessorr4() {
		Professor dummy = new Professor();
		assertTrue(dummy.prefersLocation(Location.SquirrelHill));
	}	
	
	//A Business Person prefers Squirrel Hill and Downtown - following 2 tests
	//Create a new Business Person
	//Ensure the prefersLocation method returns true for Squirrel Hill and Downtown
	@Test
	public void testBusinessPerson1() {
        BusinessPerson dummy = new BusinessPerson();
        assertTrue(dummy.prefersLocation(Location.SquirrelHill));
	}
	
	@Test
	public void testBusinessPerson2() {
		BusinessPerson dummy = new BusinessPerson();
        assertTrue(dummy.prefersLocation(Location.Downtown));
	}
	
	//A Student prefers Squirrel Hill and Downtown - following 3 tests
	//Create a new Student
	//Ensure the prefersLocation method returns true for Squirrel Hill, The Point and Downtown
	@Test
	public void testStudent1() {
		Student dummy = new Student();
	    assertTrue(dummy.prefersLocation(Location.SquirrelHill));
	}
		
	@Test
	public void testStudent2() {
		Student dummy = new Student();
	    assertTrue(dummy.prefersLocation(Location.Downtown));
	}
		
	@Test
	public void testStudent3() {
		Student dummy = new Student();
	    assertTrue(dummy.prefersLocation(Location.ThePoint));
	}
	
	
	//The requirements state that 5 visitors shall traverse the city
	//Ensure that the list of visitors that gets created is equal to 5
	@Test
	public void testVisitorList() {
		VisitorListGenerator testList = new VisitorListGenerator(0);
		LinkedList<Visitor> visTest = testList.getVisitorList();
		assertEquals(5, visTest.size());
	}
	
	//Test the getLocation method
	@Test
	public void testLocationGenerator() {
		Location locationTest[];
		locationTest = new Location[1];
		locationTest[0] = Location.ThePoint;
		assertSame(locationTest[0], Location.ThePoint);
	}
	
}
