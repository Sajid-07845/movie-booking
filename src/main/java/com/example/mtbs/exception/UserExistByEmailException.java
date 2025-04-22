package com.example.mtbs.exception;

public class UserExistByEmailException extends RuntimeException
{
  public UserExistByEmailException(String message)
  {
    super(message);
  }
}
