public class EmailValidationUtil {

    private static final String RX_EMAIL_LOCAL = "(([a-z0-9_%+\"\\-åäö])+\\.?)+(?<!\\.)@";
    private static final String RX_EMAIL_DOMAIN = "[a-z0-9][a-z0-9\\-]*\\.([a-z0-9\\-]+\\.)*";
    private static final String RX_EMAIL_DOMAIN_TAIL_CHARS = "[a-z]{2,6}";
    private static final String RX_EMAIL_DOMAIN_TAIL_INTS = "[0-9]{1,3}";
    private static final String RX_EMAIL_DOMAIN_TAIL_COMBINED = "(" + RX_EMAIL_DOMAIN_TAIL_CHARS + "|" + RX_EMAIL_DOMAIN_TAIL_INTS + ")";
    private static final String RX_EMAIL_DOMAIN_WITH_OR_WITHOUT_BRACKETS = "(\\[" + RX_EMAIL_DOMAIN + RX_EMAIL_DOMAIN_TAIL_INTS + "\\]|" + RX_EMAIL_DOMAIN + RX_EMAIL_DOMAIN_TAIL_COMBINED + ")";

    private static final Pattern RX_EMAIL_VALIDATION = Pattern.compile(RX_EMAIL_LOCAL + RX_EMAIL_DOMAIN_WITH_OR_WITHOUT_BRACKETS + "$", Pattern.CASE_INSENSITIVE);

    public static boolean isValidEmailAddress(String emailAddress) {
        return RX_EMAIL_VALIDATION.matcher(emailAddress).matches();
    }

}
