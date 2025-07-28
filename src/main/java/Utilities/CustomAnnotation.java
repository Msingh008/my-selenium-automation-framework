package Utilities;

public @interface CustomAnnotation {
    String AuthorName() default "";
    String testCategory() default "";
}
