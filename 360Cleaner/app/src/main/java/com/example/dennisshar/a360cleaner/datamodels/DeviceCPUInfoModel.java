package com.example.dennisshar.a360cleaner.datamodels;

public class DeviceCPUInfoModel {

    private String processor;
    private String vendor_id;
    private String cpu_family;
    private String model;
    private String model_name;
    private String stepping;
    private String microcode;
    private String cpu_MHz;
    private String cache_size;
    private String physical_id;
    private String siblings;
    private String core_id;
    private String cpu_cores;
    private String flags;
    private String address_sizes;
    private String dateOfMeasurment;


    public String getDateOfMeasurment() {
        return dateOfMeasurment;
    }

    public void setDateOfMeasurment(String dateOfMeasurment) {
        this.dateOfMeasurment = dateOfMeasurment;
    }



    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getVendor_id() {
        return vendor_id;
    }

    public void setVendor_id(String vendor_id) {
        this.vendor_id = vendor_id;
    }

    public String getCpu_family() {
        return cpu_family;
    }

    public void setCpu_family(String cpu_family) {
        this.cpu_family = cpu_family;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    public String getStepping() {
        return stepping;
    }

    public void setStepping(String stepping) {
        this.stepping = stepping;
    }

    public String getMicrocode() {
        return microcode;
    }

    public void setMicrocode(String microcode) {
        this.microcode = microcode;
    }

    public String getCpu_MHz() {
        return cpu_MHz;
    }

    public void setCpu_MHz(String cpu_MHz) {
        this.cpu_MHz = cpu_MHz;
    }

    public String getCache_size() {
        return cache_size;
    }

    public void setCache_size(String cache_size) {
        this.cache_size = cache_size;
    }

    public String getPhysical_id() {
        return physical_id;
    }

    public void setPhysical_id(String physical_id) {
        this.physical_id = physical_id;
    }

    public String getSiblings() {
        return siblings;
    }

    public void setSiblings(String siblings) {
        this.siblings = siblings;
    }

    public String getCore_id() {
        return core_id;
    }

    public void setCore_id(String core_id) {
        this.core_id = core_id;
    }

    public String getCpu_cores() {
        return cpu_cores;
    }

    public void setCpu_cores(String cpu_cores) {
        this.cpu_cores = cpu_cores;
    }

    public String getFlags() {
        return flags;
    }

    public void setFlags(String flags) {
        this.flags = flags;
    }

    public String getAddress_sizes() {
        return address_sizes;
    }

    public void setAddress_sizes(String address_sizes) {
        this.address_sizes = address_sizes;
    }
}
