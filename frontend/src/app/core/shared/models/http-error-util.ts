import { HttpErrorResponse } from '@angular/common/http';
import {
  ApiErrorResponse,
  ParsedApiError,
  ValidationErrorResponse
} from './error-response.model';

export function parseHttpError(
  error: HttpErrorResponse
): ParsedApiError {
  const validationResponse =
    error.error as ValidationErrorResponse;

  if (
    error.status === 400 &&
    Array.isArray(validationResponse?.fieldErrors)
  ) {
    const validationErrors: Record<string, string> = {};

    for (const fieldError of validationResponse.fieldErrors) {
      validationErrors[fieldError.field] = fieldError.message;
    }

    return {
      validationErrors,
      apiError: null
    };
  }

  const apiResponse = error.error as ApiErrorResponse;

  return {
    validationErrors: {},
    apiError:
      apiResponse?.message ??
      getDefaultErrorMessage(error)
  };
}

function getDefaultErrorMessage(error: HttpErrorResponse): string {
  switch (error.status) {
    case 0:
      return 'The server is unavailable';
    case 404:
      return 'The requested endpoint was not found';
    case 409:
      return 'The request conflicts with existing data';
    case 500:
      return 'An internal server error occurred';
    default:
      return 'An unexpected error occurred';
  }
}
