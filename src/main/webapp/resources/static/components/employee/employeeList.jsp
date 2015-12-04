<div class="container">
  <h2 ng-bind="tableName"></h2>

  <table class="table table-hover">
    <thead>
    <tr>
      <th>Id Employee</th>
      <th>Name</th>
      <th>Surname</th>
      <th>Is Active</th>
      <th>Orders</th>
      <th></th>
    </tr>
    </thead>
    <tbody>
    <tr data-ng-repeat="employee in listEmployees">
      <td ng-bind="employee.id_emp"></td>
      <td ng-bind="employee.name"></td>
      <td ng-bind="employee.surname"></td>
      <td ng-bind="employee.isActive"></td>
      <td>
        <div class="dropdown">
          <button class="btn btn-info dropdown-toggle" type="button" data-toggle="dropdown" ng-bind="employee.orders.length">
            <span class="caret"></span>
          </button>
          <ul class="dropdown-menu"  >
            <li> <a href="#/items/Orders/new"  data-toggle="tooltip">Create new Order</a></li>
            <li ng-repeat="order in employee.orders">
              <a href="#/items/Orders/{{order.id_order}}" ng-bind="order.orderscol"></a>
            </li>
          </ul>
        </div>
      </td>
      <td>
        <a href="#/items/Employees/{{employee.id_emp}}" class="btn btn-default" data-toggle="tooltip" title="Edit employee"><span class="glyphicon glyphicon-pencil"></span></a>
        <a href="#/items/Employees/del/{{employee.id_emp}}" class="btn btn-default" data-toggle="tooltip" title="Delete employee"><span class="glyphicon glyphicon-remove"></span></a>
      </td>
    </tr>
    </tbody>
  </table>
</div>
<a href="#/items/Employees/new" class="btn btn-primary">New Employee</a>
