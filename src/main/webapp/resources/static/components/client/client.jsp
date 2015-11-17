<div class="container">
  <table class="table table-striped">
    <thead>
    <tr>
      <th>Id Client</th>
      <th>Name</th>
      <th>Phone</th>
      <th>Details</th>
      <th>Orders</th>
    </tr>
    </thead>
    <tbody>
    <tr>
      <td ng-bind="client.id_cl"></td>
      <td ng-bind="client.name"></td>
      <td ng-bind="client.telephone"></td>
      <td ng-bind="client.details"></td>
      <td>
        <div class="dropdown">
          <button class="btn btn-info dropdown-toggle" type="button" data-toggle="dropdown" ng-bind="client.orders.length">
            <span class="caret"></span>
          </button>
          <ul class="dropdown-menu"  >
            <li ng-repeat="order in client.orders">
              <a href="#/items/Orders/{{order.id_order}}" ng-bind="order.orderscol"></a>
            </li>
          </ul>
        </div>
      </td>
    </tr>
    </tbody>
  </table>
</div>