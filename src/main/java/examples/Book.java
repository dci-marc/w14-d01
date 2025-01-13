package examples;

// What are the benefits of functional programming?
// Basically its code like if-else making it into an object.

// 1. Easier to read and maintain
// 2. Easier to test
// 3. Easier to debug
// 4. Easier to parallelize
// 5. Easier to optimize
// 6. Easier to reuse
// 7. Easier to compose
// 8. Easier to extend
// 9. Easier to scale
// 10. Easier to learn

// 1. Example: Writing a book.
/**
 * Like the StringBuilder class, with the append method you are extending the books content.
 * Using append() is a more of a natural language instead of string concatenation.
 */

public class Book {
  private String content = "";
  private Boolean chapterStarted = false;
  private Boolean paragraphStarted = false;

  public Book startChapter(String title) {
    this.content += "Chapter: " + title + "\n";
    this.chapterStarted = true;

    return this;
  }

  public Book startParagraph(String paragraph) {
    if (!this.chapterStarted) {
      throw new IllegalStateException("Chapter not started");
    }
    this.content += paragraph + "\n";
    this.paragraphStarted = true;

    return this;
  }

  public Book endParagraph() {
    if (!this.paragraphStarted) {
      throw new IllegalStateException("Paragraph not started");
    }
    this.content += "\n";
    this.paragraphStarted = false;

    return this;
  }

  public Book addText(String text) {
    if (!this.paragraphStarted) {
      throw new IllegalStateException("Paragraph not started");
    }
    this.content += text;
    return this;
  }

  public Book endChapter() {
    if (!this.chapterStarted) {
      throw new IllegalStateException("Chapter not started");
    }
    this.content += "The end\n";
    this.chapterStarted = false;

    return this;
  }

  public String getContent() {
    return this.content;
  }
}
