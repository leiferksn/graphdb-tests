package com.example.accessingdataneo4j.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Node
public class Component {

    @Id
    @GeneratedValue
    private String id;

    private String type;

    private String name;

    private Point coordinates;

    @Relationship(type = "IS-BASE-FOR", direction = Relationship.Direction.INCOMING)
    private Set<Component> components;

    @Relationship(type = "CONNECTS-WITH")
    private Component equalComponent;

    public void addComponent(final Component aComponent) {
        if (this.components == null) {
            this.components = new HashSet<>();
        }
        this.components.add(aComponent);
    }

    public void connectsWith(final Component aComponent) {
        this.equalComponent = aComponent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Point getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Point coordinates) {
        this.coordinates = coordinates;
    }

    public Set<Component> getComponents() {
        return components;
    }

    public Component getEqualComponent() {
        return equalComponent;
    }

    private static class Point {
        private BigDecimal x;
        private BigDecimal y;
        private BigDecimal z;

        public BigDecimal getX() {
            return x;
        }

        public void setX(BigDecimal x) {
            this.x = x;
        }

        public BigDecimal getY() {
            return y;
        }

        public void setY(BigDecimal y) {
            this.y = y;
        }

        public BigDecimal getZ() {
            return z;
        }

        public void setZ(BigDecimal z) {
            this.z = z;
        }
    }

}
