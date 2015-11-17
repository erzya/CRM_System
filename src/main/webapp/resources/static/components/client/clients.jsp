<div class="container">
    <h2 ng-bind="tableName"></h2>

    <table class="table table-hover">
        <thead>
        <tr>
            <th>Id Client</th>
            <th>Name</th>
            <th>Phone</th>
            <th>Details</th>
            <th>Orders</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
            <tr data-ng-repeat="client in listClients">
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
                            <li> <a href="#/items/Orders/new"  data-toggle="tooltip">Create new Order</a></li>
                            <li ng-repeat="order in client.orders">
                                <a href="#/items/Orders/{{order.id_order}}" ng-bind="order.orderscol"></a>
                            </li>
                        </ul>
                    </div>
                </td>
                <td>
                    <a href="#/items/Clients/del/{{client.id_cl}}" class="btn btn-default" data-toggle="tooltip" title="Delete client"><span class="glyphicon glyphicon-remove"></span></a>
                </td>
            </tr>
        </tbody>
    </table>
</div>
<a href="#/items/Clients/new" class="btn btn-primary">New Client</a>
