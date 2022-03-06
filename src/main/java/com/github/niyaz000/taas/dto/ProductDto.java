package com.github.niyaz000.taas.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Accessors(fluent = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductDto {

  @NotBlank(message = "'name' cannot be blank or null")
  @Size(min = 1, max = 255, message = "length must be between 1 to 255")
  private String name;

  @Min(value = 1, message = "must be between 1 to 500")
  @Max(value = 255, message = "must be between 1 to 500")
  private Long maximumNumberOfTagsPerEntity;

  @Min(value = 1, message = "must be between 1 to 255")
  @Max(value = 255, message = "must be between 1 to 255")
  private Long minimumTagLength;

  @Min(value = 1, message = "must be between 1 to 255")
  @Max(value = 255, message = "must be between 1 to 255")
  private Long maximumTagLength;

  private Long maximumNumberOfAccounts;

  private boolean allowWildCardSearch;

  private boolean tagsImmutable;

  private boolean allowTagMerge;

  private boolean allowTagSplit;

}
