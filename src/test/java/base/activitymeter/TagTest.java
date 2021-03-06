package base.activitymeter;

import org.junit.Assert;
import org.junit.Test;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;

public class TagTest {

	@Test
	  public void validateSettersAndGetters() {


	    PojoClass tagPojo = PojoClassFactory.getPojoClass(Tag.class);


	    Validator validator = ValidatorBuilder.create()
	        // Lets make sure that we have a getter and a setter for every field defined.
	        .with(new SetterMustExistRule()).with(new GetterMustExistRule())

	        // Lets also validate that they are behaving as expected
	        .with(new SetterTester()).with(new GetterTester()).build();

	    // Start the Test
	    validator.validate(tagPojo);
	  }
	@Test(timeout = 1_000) public void tagIdTestTrue() {
	      // arrange
	      Tag sut = new Tag("#GoodDay");
	      sut.setId(40071);
	      boolean want = true;
	      // act
	      boolean have = sut.checkId(40071);
	      // assert
	      Assert.assertEquals(want, have);
	  }  
	@Test(timeout = 1_000) public void tagIdTestFalse() {
	    // arrange
	      Tag sut = new Tag("#GoodDay");
	      sut.setId(40071);
	      boolean want = false;
	      // act
	      boolean have = sut.checkId(40073);
	      // assert
	      Assert.assertEquals(want, have);
	  }  
	@Test(timeout = 1_000) public void tagKeywordTestTrue() {
	    // arrange
	      Tag sut = new Tag("#RightKeyword");
	      boolean want = true;
	      // act
	      boolean have = sut.checkKeyword("#RightKeyword");
	      // assert
	      Assert.assertEquals(want, have);
	  }  
	@Test(timeout = 1_000) public void tagKeywordTestFalse() {
	    // arrange
	      Tag sut = new Tag("#RightKeyword");
	      boolean want = false;
	      // act
	      boolean have = sut.checkKeyword("#WrongKeyword");
	      // assert
	      Assert.assertEquals(want, have);
	  }  
	
}
