package edu.cnm.deepdive.server.controller.exception;

/**
 * Throws an exception if the search term is too short.  It extends the illegal argument exception.
 */
public class SearchTermTooShortException extends IllegalArgumentException {

  public SearchTermTooShortException() {
    super();
  }

  public SearchTermTooShortException(String s) {
    super(s);
  }

  public SearchTermTooShortException(String message, Throwable cause) {
    super(message, cause);
  }

  public SearchTermTooShortException(Throwable cause) {
    super(cause);
  }


}
