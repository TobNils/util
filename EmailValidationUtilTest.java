@Category(UnitTest.class)
public class EmailValidationUtilTest {

    @Test
    public void testValidEmails() {
        Set<String> emails = addValidEmails();
        for (String email : emails) {
            boolean validEmailAddress = EmailValidationUtil.isValidEmailAddress(email);
            Assert.assertTrue(email, validEmailAddress);
        }
    }

    @Test
    public void testInvalidEmails() {
        Set<String> emails = addInvalidEmails();
        for (String email : emails) {
            boolean invalidEmailAddress = EmailValidationUtil.isValidEmailAddress(email);
            Assert.assertFalse(email, invalidEmailAddress);
        }
    }

    //@TODO TOBNIL Change the regex so that it can take all of the wanted cases, maybe we don't want all of them.
    private static Set<String> addValidEmails() {
        Set<String> validEmails = Sets.newHashSet();

        // These example mails are from http://codefool.tumblr.com/post/15288874550/list-of-valid-and-invalid-email-addresses
        validEmails.add("email@example.com");
        validEmails.add("firstname.lastname@example.com");
        validEmails.add("email@subdomain.example.com");
        validEmails.add("firstname+lastname@example.com");
        validEmails.add("email@123.123.123.123");
        validEmails.add("email@[123.123.123.123]");
        validEmails.add("\"email\"@example.com");
        validEmails.add("1234567890@example.com");
        validEmails.add("email@example-one.com");
        validEmails.add("_______@example.com");
        validEmails.add("email@example.name");
        validEmails.add("email@example.museum");
        validEmails.add("email@example.co.jp");
        validEmails.add("firstname-lastname@example.com");
        validEmails.add("email@abc.-hej.com");
        validEmails.add("email@a.-hej.com");
        validEmails.add("email@a.com");

        // These example mails are from https://en.wikibooks.org/wiki/JavaScript/Best_practices
        validEmails.add("me@example.com");
        validEmails.add("a.nonymous@example.com");
        validEmails.add("name+tag@example.com");
//        validEmails.add("name\"@\"tag@example.com");
//        validEmails.add("spaces\\ are\\ allowed@example.com");
//        validEmails.add("\"spaces may be quoted\"@example.com");
//        validEmails.add("!#$%&\'*+-/=.?^_`{|}~@[1.0.0.127]");
//        validEmails.add("!#$%&\'*+-/=.?^_`{|}~@[IPv6:0123:4567:89AB:CDEF:0123:4567:89AB:CDEF]");

        return validEmails;
    }

    private static Set<String> addInvalidEmails() {
        Set<String> invalidEmails = Sets.newHashSet();

        // These example mails are from http://codefool.tumblr.com/post/15288874550/list-of-valid-and-invalid-email-addresses
        invalidEmails.add("plainaddress");
        invalidEmails.add("#@%^%#$@#$@#.com");
        invalidEmails.add("@example.com");
        invalidEmails.add("Joe Smith <email@example.com>");
        invalidEmails.add("email.example.com");
        invalidEmails.add("email@example@example.com");
        invalidEmails.add(".email@example.com");
        invalidEmails.add("email.@example.com");
        invalidEmails.add("email..email@example.com");
        invalidEmails.add("あいうえお@example.com");
        invalidEmails.add("email@example.com (Joe Smith)");
        invalidEmails.add("email@example");
        invalidEmails.add("email@-example.com");
        invalidEmails.add("email@111.222.333.44444");
        invalidEmails.add("email@example..com");
        invalidEmails.add("Abc..123@example.com");

        // These example mails are from https://en.wikibooks.org/wiki/JavaScript/Best_practices
        invalidEmails.add("me@");
        invalidEmails.add("@example.com");
        invalidEmails.add("me.@example.com");
        invalidEmails.add(".me@example.com");
        invalidEmails.add("me@example..com");
        invalidEmails.add("me.example@com");
        invalidEmails.add("me @example.com");

        return invalidEmails;
    }
}
