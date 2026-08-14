export interface FieldError {
  field: string;
  message: string;
}

export interface ValidationErrorResponse {
  fieldErrors?: FieldError[];
}

export interface ApiErrorResponse {
  message?: string;
}

export interface ParsedApiError {
  validationErrors: Record<string, string>;
  apiError: string | null;
}
