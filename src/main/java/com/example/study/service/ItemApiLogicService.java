package com.example.study.service;

import com.example.study.ifs.CrudInterface;
import com.example.study.model.entity.Item;
import com.example.study.model.entity.Partner;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.ItemApiRequest;
import com.example.study.model.network.response.ItemApiResponse;
import com.example.study.repository.ItemRepository;
import com.example.study.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import sun.jvm.hotspot.memory.HeapBlock;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ItemApiLogicService implements CrudInterface<ItemApiRequest, ItemApiResponse> {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private PartnerRepository partnerRepository;

    @Override
    public Header<ItemApiResponse> create(Header<ItemApiRequest> request) {
        //request로 부터 데이터 받아오기
        ItemApiRequest itemApiRequest =  request.getData();
        //데이터 입력하기
        Item item = Item.builder()
                .status(itemApiRequest.getStatus())
                .name(itemApiRequest.getName())
                .title(itemApiRequest.getTitle())
                .content(itemApiRequest.getContent())
                .price(itemApiRequest.getPrice())
                .brandName(itemApiRequest.getBrandName())
                .registeredAt(LocalDateTime.now())
                .partner(partnerRepository.getOne(itemApiRequest.getId()))
                .build();
        Item newItem = itemRepository.save(item);
        return response(newItem);
    }

    @Override
    public Header<ItemApiResponse> read(Long id) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        return optionalItem.map(fi -> response(fi))
                .orElseGet(()->Header.Error("데이터가 없습니다"));
    }

    @Override
    public Header<ItemApiResponse> update(Header<ItemApiRequest> request) {
        ItemApiRequest itemApiRequest = request.getData();
        Optional<Partner> p = partnerRepository.findById(itemApiRequest.getPartnerId());
        Partner selected_p = p.orElse(null);
        if(selected_p==null){
            return Header.Error("PartnerId가 없습니다");
        }

        Optional<Item> optionalItem = itemRepository.findById(itemApiRequest.getId());
       return optionalItem.map( i ->{
            return i.setStatus(itemApiRequest.getStatus())
                    .setName(itemApiRequest.getName())
                    .setTitle(itemApiRequest.getTitle())
                    .setContent(itemApiRequest.getContent())
                    .setPrice(itemApiRequest.getPrice())
                    .setBrandName(itemApiRequest.getBrandName())
                    .setPartner(selected_p)
                    .setRegisteredAt(LocalDateTime.now());
        }).map(Item -> itemRepository.save(Item))
        .map(newItem ->response(newItem))
        .orElseGet(() ->Header.Error("데이터가 없습니다."));
    }
    @Override
    public Header delete(Long id) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        return optionalItem.map(s -> {
            itemRepository.delete(s);
            return Header.Ok();
        }).orElseGet(() ->Header.Error("데이터가 없습니다"));
    }

    private Header<ItemApiResponse> response(Item item)
    {
        ItemApiResponse itemApiResponse = ItemApiResponse.builder()
                .id(item.getId())
                .status(item.getStatus())
                .name(item.getName())
                .title(item.getTitle())
                .content(item.getContent())
                .price(item.getPrice())
                .brandName(item.getBrandName())
                .partnerId(item.getPartner().getId())
                .registeredAt(item.getRegisteredAt())
                .unregisteredAt(item.getUnregisteredAt())
                .build();
        return Header.Ok(itemApiResponse);
    }
}
