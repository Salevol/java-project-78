### Hexlet tests and linter status:
[![Actions Status](https://github.com/Salevol/java-project-78/workflows/hexlet-check/badge.svg)](https://github.com/Salevol/java-project-78/actions)
<a href="https://codeclimate.com/github/Salevol/java-project-78/maintainability"><img src="https://api.codeclimate.com/v1/badges/82adeca07f18cc6cfce7/maintainability" /></a>
<a href="https://codeclimate.com/github/Salevol/java-project-78/test_coverage"><img src="https://api.codeclimate.com/v1/badges/82adeca07f18cc6cfce7/test_coverage" /></a>

# Data Validator
Simple programme to validate data of String, Integer or Map type.

Validator.string() applies checks for null or empty, minimal string length and if it contains substring;

Validator.number() applies checks for null, positive or in range;

Validator.map() applies checks for null, minimal size or in shape of {valid key: validator}.
