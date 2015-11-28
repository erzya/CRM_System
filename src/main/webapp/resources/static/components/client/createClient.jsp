<!-- FORM -->
<h1>Create client</h1>
<!-- pass in the variable if our form is valid or invalid -->
<form name="clientForm" ng-submit="saveClient()" novalidate> <!-- novalidate prevents HTML5 validation since we will be validating ourselves -->

  <!-- NAME -->
  <div ng-class="{ 'has-error' : clientForm.name.$invalid && !clientForm.name.$pristine}">
    <label>Client name</label>
    <input type="text" name="name" class="form-control" ng-model="client.name" required ng-minlength="3" ng-maxlength="30">
    <p ng-show="clientForm.name.$error.required">You did not enter a field</p>
    <p ng-show="clientForm.name.$error.minlength" class="help-block">Client name should be over 2 characters</p>
    <p ng-show="clientForm.name.$error.maxlength" class="help-block">Client name should be less than 30 characters</p>
  </div>

  <!-- Phone-->
  <div ng-class="{ 'has-error' : clientForm.phone.$invalid && !clientForm.phone.$pristine }">
    <label>Phone</label>
    <input type="text" name="phone" class="form-control" ng-model="client.telephone" required ng-pattern="/^[0-9]+$/" ng-minlength="7" ng-maxlength="16">
    <p ng-show="clientForm.phone.$error.required">You did not enter a field</p>
    <p ng-show="clientForm.phone.$error.minlength" class="help-block">Client phone number should consist of more than 6 digits</p>
    <p ng-show="clientForm.phone.$error.maxlength" class="help-block">Client phone number should consist of less than 17 digits</p>
    <p ng-show="clientForm.phone.$error.pattern" class="help-block">Only digits allowed</p>
  </div>

  <!-- Details -->
  <div class="form-group">
    <label>Details</label>
    <input type="text" name="details" class="form-control" ng-model="client.details" ng-minlength="10" ng-maxlength="100">
    <p ng-show="clientForm.details.$error.minlength" class="help-block">Please give us more details</p>
    <p ng-show="clientForm.details.$error.maxlength" class="help-block">Length of message can't be more than 100 characters</p>
  </div>

  <!-- SUBMIT BUTTON -->
  <button type="submit" class="btn btn-primary">Submit</button>

</form>