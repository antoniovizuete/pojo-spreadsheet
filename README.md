# POJO-Spreadsheet

Project that wraps `Apache POI` and gives you a semantical use of it. Meaning that a Spreadsheet is made of Rows, and a Row is made of Cells.
```xml
<dependency>
    <groupId>io.github.antoniovizuete</groupId>
    <artifactId>pojo-spreadsheet</artifactId>
    <version>0.1.1</version>
</dependency>
```
---
##### Working on documentation

# Changelog
## [Unreleased]
 - Deprecated methods
 - Clean the API

## [0.1.1] 2018-09-06
### Added
 - `Spreadsheet.performWrite()` method has been added in order to return the OutputStream created by the SpreadsheetWriter
### Changed
 - The `Cell` API has been cleaned
 - The `Row` API has been cleaned
 - The `SpreadsheetWirter` API has been cleaned
 - The implementations of `SpreadsheetWirter` have been renamed
 
### Deprecated 
 - `Spreadsheet.write()` has been deprecated, use `Spreadsheet.performWrite()` instead.
### Fixed
 - `NullPointerException` throwed when it tries to convert null-value cell to POI

## [0.1] 2018-09-05
First released version
