/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package dom.todo;

import java.util.List;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;

@Named("Customers")
public class Customers {

    @MemberOrder(sequence="1")
    public Customer newCustomer(
            @Named("First name") String firstName,
            @Named("Last name") String lastName) {
        Customer customer = container.newTransientInstance(Customer.class);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        container.persist(customer);
        return customer;
    }
    
    @MemberOrder(sequence="2")
    public List<Customer> allCustomers() {
        return container.allInstances(Customer.class);
    }
    
    
    // {{ injected: DomainObjectContainer
    private DomainObjectContainer container;

    public void setDomainObjectContainer(final DomainObjectContainer container) {
        this.container = container;
    }
    // }}


}
