//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.kvtag.models;

import ai.qworks.dao.annotations.Mandatory;
import ai.qworks.dao.annotations.SharedObject;
import ai.qworks.dao.base.BaseEntity;
import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

@Container(
        containerName = "Category"
)
@SharedObject
@JsonIgnoreProperties(
        ignoreUnknown = true
)
@Getter
@Setter
public class Category extends BaseEntity {
    private static final long serialVersionUID = 4161900597545680943L;
    @Mandatory
    public Boolean isRootOffering;
    @Mandatory
    public Boolean isPrimordial;
    @Mandatory
    public Boolean isAncestor;
    private String rootId;
    private String primordialId;
    private String type;
    private String image;
    public boolean isSearchable;
    @PartitionKey
    private String priceListId;
    private String priceListName;

    private List<KVTag> kvTags;

    public String toFilterableString() {
        StringBuilder sb = new StringBuilder();

        if(this.kvTags != null && !this.kvTags.isEmpty()) {
            for(KVTag kvTag : this.kvTags) {
                sb.append(kvTag.getName());
                String values = String.join(", ", kvTag.getValues());
                if(StringUtils.isNotBlank(values)) {
                    sb.append("##").append(values).append(", ");
                }
            }
        }

        return this.priceListName + ", " + this.type + ", " + sb;
    }

    public String toString() {
        Boolean var10000 = this.getIsRootOffering();
        return "Category(isRootOffering=" + var10000 + ", isPrimordial=" + this.getIsPrimordial() + ", isAncestor=" + this.getIsAncestor() + ", rootId=" + this.getRootId() + ", primordialId=" + this.getPrimordialId() + ", type=" + this.getType() + ", image=" + this.getImage() + ", isSearchable=" + this.isSearchable() + ", priceListId=" + this.getPriceListId() + ", priceListName=" + this.getPriceListName() + ")";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Category)) {
            return false;
        } else {
            Category other = (Category)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.isSearchable() != other.isSearchable()) {
                return false;
            } else {
                label121: {
                    Object this$isRootOffering = this.getIsRootOffering();
                    Object other$isRootOffering = other.getIsRootOffering();
                    if (this$isRootOffering == null) {
                        if (other$isRootOffering == null) {
                            break label121;
                        }
                    } else if (this$isRootOffering.equals(other$isRootOffering)) {
                        break label121;
                    }

                    return false;
                }

                Object this$isPrimordial = this.getIsPrimordial();
                Object other$isPrimordial = other.getIsPrimordial();
                if (this$isPrimordial == null) {
                    if (other$isPrimordial != null) {
                        return false;
                    }
                } else if (!this$isPrimordial.equals(other$isPrimordial)) {
                    return false;
                }

                label107: {
                    Object this$isAncestor = this.getIsAncestor();
                    Object other$isAncestor = other.getIsAncestor();
                    if (this$isAncestor == null) {
                        if (other$isAncestor == null) {
                            break label107;
                        }
                    } else if (this$isAncestor.equals(other$isAncestor)) {
                        break label107;
                    }

                    return false;
                }

                Object this$rootId = this.getRootId();
                Object other$rootId = other.getRootId();
                if (this$rootId == null) {
                    if (other$rootId != null) {
                        return false;
                    }
                } else if (!this$rootId.equals(other$rootId)) {
                    return false;
                }

                Object this$primordialId = this.getPrimordialId();
                Object other$primordialId = other.getPrimordialId();
                if (this$primordialId == null) {
                    if (other$primordialId != null) {
                        return false;
                    }
                } else if (!this$primordialId.equals(other$primordialId)) {
                    return false;
                }

                label86: {
                    Object this$type = this.getType();
                    Object other$type = other.getType();
                    if (this$type == null) {
                        if (other$type == null) {
                            break label86;
                        }
                    } else if (this$type.equals(other$type)) {
                        break label86;
                    }

                    return false;
                }

                label79: {
                    Object this$image = this.getImage();
                    Object other$image = other.getImage();
                    if (this$image == null) {
                        if (other$image == null) {
                            break label79;
                        }
                    } else if (this$image.equals(other$image)) {
                        break label79;
                    }

                    return false;
                }

                Object this$priceListId = this.getPriceListId();
                Object other$priceListId = other.getPriceListId();
                if (this$priceListId == null) {
                    if (other$priceListId != null) {
                        return false;
                    }
                } else if (!this$priceListId.equals(other$priceListId)) {
                    return false;
                }

                Object this$priceListName = this.getPriceListName();
                Object other$priceListName = other.getPriceListName();
                if (this$priceListName == null) {
                    if (other$priceListName != null) {
                        return false;
                    }
                } else if (!this$priceListName.equals(other$priceListName)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof Category;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        result = result * 59 + (this.isSearchable() ? 79 : 97);
        Object $isRootOffering = this.getIsRootOffering();
        result = result * 59 + ($isRootOffering == null ? 43 : $isRootOffering.hashCode());
        Object $isPrimordial = this.getIsPrimordial();
        result = result * 59 + ($isPrimordial == null ? 43 : $isPrimordial.hashCode());
        Object $isAncestor = this.getIsAncestor();
        result = result * 59 + ($isAncestor == null ? 43 : $isAncestor.hashCode());
        Object $rootId = this.getRootId();
        result = result * 59 + ($rootId == null ? 43 : $rootId.hashCode());
        Object $primordialId = this.getPrimordialId();
        result = result * 59 + ($primordialId == null ? 43 : $primordialId.hashCode());
        Object $type = this.getType();
        result = result * 59 + ($type == null ? 43 : $type.hashCode());
        Object $image = this.getImage();
        result = result * 59 + ($image == null ? 43 : $image.hashCode());
        Object $priceListId = this.getPriceListId();
        result = result * 59 + ($priceListId == null ? 43 : $priceListId.hashCode());
        Object $priceListName = this.getPriceListName();
        result = result * 59 + ($priceListName == null ? 43 : $priceListName.hashCode());
        return result;
    }

    public Category() {
    }

    public Category(Boolean isRootOffering, Boolean isPrimordial, Boolean isAncestor, String rootId, String primordialId, String type, String image, boolean isSearchable, String priceListId, String priceListName) {
        this.isRootOffering = isRootOffering;
        this.isPrimordial = isPrimordial;
        this.isAncestor = isAncestor;
        this.rootId = rootId;
        this.primordialId = primordialId;
        this.type = type;
        this.image = image;
        this.isSearchable = isSearchable;
        this.priceListId = priceListId;
        this.priceListName = priceListName;
    }
}
