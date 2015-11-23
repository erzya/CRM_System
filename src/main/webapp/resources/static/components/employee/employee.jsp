<div class="container">
  <table class="table">
    <thead>
    <tr>
      <th>Id Employee</th>
      <th>Name</th>
      <th>Surname</th>
      <th>Orders</th>
      <th>Active</th>
    </tr>
    </thead>
    <tbody>
    <tr>
      <td ng-bind="employee.id_emp"></td>
      <td ng-bind="employee.name"></td>
      <td ng-bind="employee.surname"></td>
      <td>
        <div class="dropdown">
          <button class="btn btn-info dropdown-toggle" type="button" data-toggle="dropdown" ng-bind="employee.orders.length">
            <span class="caret"></span>
          </button>
          <ul class="dropdown-menu"  >
            <li ng-repeat="order in employee.orders">
              <a href="#/items/Orders/{{order.id_order}}" ng-bind="order.orderscol"></a>
            </li>
          </ul>
        </div>
      </td>
      <td ng-bind="employee.isActive"></td>
    </tr>
    </tbody>
  </table>
</div>